@Controller
@RequestMapping(value="/")
class ReadingListController {

    String reader = "user"

    @Autowired
    ReadingListRepository readingListRepository;

    @RequestMapping(method=RequestMethod.GET)
    def readersBooks(Model model){
        List<Book> readingList = readingListRepository.findByReader(reader);

        if(readingList){
            model.addAttribute("books", readingList)
        }

        "readingList"
    }

    @RequestMapping(method=RequestMethod.POST)
    def addToReadingList(Book book){
        book.setReader(reader)
        readingListRepository.save(book)
        "redirect:/"
    }
}
