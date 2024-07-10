# FC-EDA Challenge

This is a microservice related to the FC-EDA challenge. It receives events via Kafka from the Wallet Core module and persists the updated values for each accountId in the balances database. It also has an endpoint /balances/{account_id} to query the balance.

Use the api module to make the service requests.

To start the project, use the command:

```
docker compose -d
```

Note: The walletcore module was developed by: https://github.com/devfullcycle/fc-eda
