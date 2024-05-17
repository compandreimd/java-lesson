ANSI_RESET = "\u001B[0m"
ANSI_YELLOW = "\u001B[33m"
def Media():
        MAX = int(input("Introduceti maximum pe salariu? "))
        print("Introduceti salariele a 3 luni?")
        l1 = int(input("Prima luna? "))
        l2 = int(input("A doua luna? "))
        l3 = int(input("A treia luna? "))
        sum = l1 + l2 + l3
        print("Suma:" + str(sum))
        print("Media:" + str(sum/3))
        print(ANSI_YELLOW + "Suma depasit de " + str(MAX) + ": " + str(sum > MAX))
        print("Media depasita de " + str(MAX) + ": " + str(sum/3 > MAX))
        print(ANSI_RESET)

