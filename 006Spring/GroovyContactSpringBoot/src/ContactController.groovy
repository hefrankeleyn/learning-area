@Grab("spring-boot-starter-actuator")
@Grab("spring-boot-starter-thymeleaf")

@Controller
@RequestMapping("/")
class ContactController {

    @Autowired
    ContactDao contactDao

    @RequestMapping(method=RequestMethod.GET)
    String home(Map<String, Object> model){
        List<Contact> contacts =contactDao.findAll()
        model.putAll([contacts: contacts])
        "home"
    }

    @RequestMapping(method=RequestMethod.POST)
    String submit(Contact contact){
        contactDao.save()
        "redirect:/"
    }
}
