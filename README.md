# spring-test-rest-api
Rest-Api -> Maven Project with Spring and Hibernate 

1: Create Models and declare Primary Key / persistence

    @Id @GeneratedValue(
    strategy = GenerationType.IDENTITY)

2: Create Repo using Crud / percistence

    @Repository
    public interface StudentRepository 
    extends CrudRepository<> {
3: Create Service where logic happens / application

> public Iterable<Student> getAllStudents() {
    return studentRepository.findAll(); }

4: Create Presentation Controller / presentation
where mapping to frontend happens

        @Autowired
        private StudentService studentService;

        @GetMapping("/students")
        public @ResponseBody
        Iterable<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
