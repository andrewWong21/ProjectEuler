def number_letter_counts() -> int:
    sum: int = 0
    # letters used in writing out 1 to 1000
    ones: string = "onetwothreefourfivesixseveneightnine"
    tens: string = "twentythirtyfortyfiftysixtyseventyeightyninety"
    teens: string = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen"
    
    # (10 * 9) 1, 21, 31, 41, 51, 61, 71, 81, 91, 101, 121, ..., 991
    # (100) 100-199
    sum += len(ones) * 190
    # (10 * 10) 21-29, 121-129, 221-229, 321-329, ..., 921-929
    sum += len(tens) * 100
    # (10) 110, 210, 310, 410, 510, 610, 710, 810, 910
    sum += len(teens) * 10
    # 100-999
    sum += len("hundred") * 900
    # (9 * 99) 101-199, 201-299, 301-399, ..., 901-999
    sum += len("and") * 891
    sum += len("onethousand")
    return sum

if __name__ == "__main__":
    print(number_letter_counts())