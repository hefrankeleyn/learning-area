
@Grab("spring-boot-starter-test")
import org.springframework.test.web.servlet.MockMvc
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import static org.mockito.Mockito.*
import org.junit.Test

class ReadingListControllerTest {

    @Test
    void shouldReturnReadingListFromRepository(){
        List<Book> expectedList = new ArrayList<>()
        Book exportBook = new Book(id: 1,
                reader: "user",
                isbn: "2361",
                title: "Spring in Action",
                author: "Craig",
                description: "Good book")
        expectedList.add(exportBook)


        def mockRepo = mock(ReadingListRepository.class)
        mockRepo.save(exportBook)
        when(mockRepo.findByreader("user").thenReturn(expectedList))

        def controller = new ReadingListController(readingListRepository: mockRepo)

        MockMvc mvc = standaloneSetup(controller).build()
        mvc.perform(get("/"))
                .andExpect(view().name("readingList"))
                .andExpect(view().attribute("books", expectedList))
    }
}