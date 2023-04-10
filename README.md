# Payment Service

An application for processing incoming HTTP POST requests

## User manual
### Mongo settings
* Address: utils.DataSourceFactory, URI ```mongodb://localhost:27017/?appName=PaymentService```
* Table: clients
* Collection: payments

### App launch
1. Launch a Mongo server and create ```clients``` table with a ```payments``` collection using the config mentioned above
2. Open the project folder in terminal and execute the following command ```./gradlew jettyRun```
3. Send a POST-request to the following endpoint ```http://localhost:8080/PaymentService/savePayment```, for example:

```json
{
	"id": "1",
	"userId": 111,
	"sum": 100
}
```

You should receive ```200ОК``` in the response, the body of this response should contain ```0```, if the payment with this ```id``` doesn't exist in the table, or ```1``` if it does:

```json
{
	"status": 1
}
```
