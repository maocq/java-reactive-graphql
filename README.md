# Java

```graphql
query GetBankAccount {
    getBankAccount(id: "123") {
        id
        userName
        balance
    }
}
```

```graphql
query GetBankAccounts {
    getBankAccounts {
        id
        userName
        balance
    }
}
```

```graphql
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