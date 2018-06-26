def get_max_profit(stocks):
    buy = stocks[0]
    sell = stocks[1]
    profit = sell - buy
    for x in range(1, len(stocks)):

        if stocks[x] - buy > profit:
            profit = stocks[x] - buy
            sell = stocks[x]
        elif stocks[x] <= buy:
            buy = stocks[x]

    return profit

print(get_max_profit(list(map(int,input()))))