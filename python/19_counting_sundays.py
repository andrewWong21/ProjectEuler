import datetime

def count_sundays() -> int:
    count: int = 0
    # use datetime object to check day of week for the first of every month from 1901-01-01 to 2000-12-31
    for year in range(1901, 2001):
        for month in range(1, 13):
            if datetime.date(year, month, 1).weekday() == 6:
                count += 1
    return count

if __name__ == "__main__":
    print(count_sundays())