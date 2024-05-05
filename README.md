# Java

```graphql
query GetBankAccount {
    getBankAccount(id: "123") {
        id
        userName
        balance
    }
}

query GetBankAccounts {
    getBankAccounts {
        id
        userName
        balance
    }
}

query GetBankAccounts {
    getBankAccounts {
        id
        userName
        balance
    }
    getBankAccount(id: "123") {
        id
        userName
        balance
    }
}
```
```sh
curl 'http://localhost:8080/graphql' \
  -H 'content-type: application/json' \
  --data-raw '{"query":"query GetBankAccounts {\n    getBankAccounts {\n        id\n        userName\n        balance\n    }\n}","operationName":"GetBankAccounts"}'
```

---

```sh
curl --location 'http://localhost:8080/api/bankaccount'

curl --location 'http://localhost:8080/api/bankaccount/id'
```