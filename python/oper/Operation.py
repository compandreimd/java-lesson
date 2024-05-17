def calc():
    name = "Andrei"
    last = "MMM"

    print(f"{name} {last} age ?")

    age = 0
    setedAge = False
    while not setedAge:
        try:
            age = int(input("Get Age?"))
            setedAge = True
        except ValueError:
            print("Wrong int:")

    print(f"Varsta mea la anu:{age + 1}")
