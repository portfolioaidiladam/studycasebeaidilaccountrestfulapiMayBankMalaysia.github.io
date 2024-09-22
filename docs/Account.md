# Account API Spec

## Get Account

Endpoint : GET /api/accounts/{customerId}

Response Body (Success) :

```json
{
  "customerId" : "12345",
  "accountNumber" : "100",
  "description" : "A123"
}
```
Response Body (Failed) :

```json
{
  "errors" : "Accounts is not found"
}
```
## Get Account Number

Endpoint : GET /api/accounts/accountNumber/{accountNumber}


Response Body (Success) :

```json
{
  "customerId" : "12345",
  "accountNumber" : "100",
  "description" : "A123"
}
```

## Update Account

Endpoint : PUT /api/accounts/{id}


Request Body :

```json
{
  "description" : "A123"
}
```


## Get All Account Pagination

Endpoint : GET /api/accounts?page={page}&size={size}


Response Body (Success) :

```json
{
  "data" : "OK"
}
```

Response Body (Failed) :

```json
{
  "errors" : "Stock is not found"
}
```