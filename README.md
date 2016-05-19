# finance-middle

## Setup

```
git clone https://github.com/JinpaLhawang/finance-middle.git
cd finance-middle
```

## Testing and Building

```
mvn test
mvn package
```

## Running

```
mongod --dbpath ~/mongodb/data/db/
mvn spring-boot:run
```

### Inserting Data

```
curl -i -X POST http://localhost:8099/financialaccounts -d '{ "name" : "Internet Expense" }' -H "Content-Type:application/json"
```

### Requesting Data

http://localhost:8099/financialaccounts
http://localhost:8099/financialaccounts/search
http://localhost:8099/financialaccounts/search/findByName?name=Internet%20Expense
