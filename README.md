# springboot-namevalidator-lhv API
API has Swagger support. Swagger is located at http://localhost:8080/swagger-ui/index.html

## Data
Blacklist and noisewords repositories are in -Repository classes. Repositories are hard coded lists at the moment.
Services are communicating with repositories.
Services are used by controllers using Dependency Injection (@Autowired)
Repositories are easily replaceable with databases or files or other data carriers.

## Logic
All the name matching logic is in NameMatchLogic class.

## Controllers
Controllers are communicating with Service and Logic classes.
