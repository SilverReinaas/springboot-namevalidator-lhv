# springboot-namevalidator-lhv API
API has Swagger support. Swagger is located at http://localhost:8080/swagger-ui/index.html

## Data
Blacklist and noisewords repositories are in -Repository classes. Repositories are hard coded lists at the moment.  
Services are communicating with repositories.  
Services are used by controllers using Dependency Injection (@Autowired)  
Repositories are easily replaceable with databases or files or other data carriers.  

## Logic
All the name matching logic is in NameMatchLogic class.  
Logic is pretty simple. Input name is divided to parts. Ex: bin laden -> {bin, laden}.  
Then blacklist names are iterated and also divided to parts. Input name parts and black list name parts are then compared and found, how many matches they have. If matches threshold (default 2/3) is exceeded, then the blacklist name is a successful match.

## Controllers
Controllers are communicating with Service and Logic classes.

## Demo
Demo video is in root folder.
