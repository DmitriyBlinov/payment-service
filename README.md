# Payment Service

Приложение для обработки поступающих HTTP POST-запросов в сервлетах

## Инструкция по запуску
### Настройки Mongo
* Адрес: по дефолту в классе utils.DataSourceFactory указан URI "mongodb://localhost:27017/?appName=PaymentService"
* Название таблицы: clients
* Название коллекции: payments

### Запуск приложения
1. Запустить Mongo-сервер и создать таблицу "clients" с коллекцией "payments", используя конфигурацию выше
2. Открыть папку проекта в терминале и выполнить команду ./gradlew jettyRun
3. Используя REST клиент, отправить на эндпоинт http://localhost:8080/PaymentService/savePayment следующий POST-реквест:

```json
{
	"id": "1",
	"userId": 111,
	"sum": 100
}
```

Респонс вернет ```200ОК```, в теле респонса будет либо ```0```, если в таблице до этого не было платежа с этим ```id```, либо ```1```, если такой уже есть:

```json
{
	"status": 1
}
```

4. Завершить выполнение программы, нажав любую кнопку в терминале