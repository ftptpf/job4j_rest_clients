# job4j_rest_clients

## RestFul API multi-module проект демонстрации работы различных клиентов

Проект включает в себя четыре сервиса:
- **Source** - сервис H2 in-memory SQL базы данных, с которым взаимодействуют сервисы-клиенты
- **RestTemplate** - сервис-клиент реализованный на базе RestTemplate
- **WebClient** - сервис-клиент реализованный на базе WebClient
- **OpenFeign** - сервис-клиент реализованный на базе OpenFeign

Клиенты имеют идентичный функционал.

### Стек технологий

- Java 17
- Spring 2.7
- H2 Database
- Swagger
- Maven 3.8
- PostMan

### Запуск сервисов

Для запуска соответствующего сервиса перейдите в командной строке в его директорию и выполните команду  
```mvn spring-boot:run```  
либо запустите сервис (метод main) непосредственно из вашей среды разработки   
![Alt-текст](https://github.com/ftptpf/job4j_rest_clients/blob/master/img/1.JPG "Запуск сервиса")

### Взаимодействие с сервисами

Все сервисы располагаются на localhost, но имеют различные порты:  
Source - порт 8080  
RestTemplate - порт 8081  
OpenFeign - порт 8082  
WebClient - порт 8083

Ко всем сервисам подключен Swagger, который позволяет автоматически генерировать описание API на основании кода проекта.
Например, по ссылке  
http://localhost:8080/swagger-ui/index.html  
можно получить доступ к Swagger сервиса Source.  
![Alt-текст](https://github.com/ftptpf/job4j_rest_clients/blob/master/img/2.JPG "Swagger сервиса Source")  
В вышеприведенной ссылке меняя порт с 8080 на 8081/8082/8083 можно получить доступ к Swagger других сервисов-клиентов.  
Для удобства работы с API можно данные из Swagger экспортировать в Postman.

По ссылке  
http://localhost:8080/h2-console  
можно получить доступ к базе данный H2.  
![Alt-текст](https://github.com/ftptpf/job4j_rest_clients/blob/master/img/3.JPG "In-memory SQL база данных H2")  
Доступ можно получить только при запущенном сервисе Source.  
Обратите внимание, что база данных H2 располагается в оперативной памяти.  
При остановке сервиса Source - все данные из база данных будут удалены.