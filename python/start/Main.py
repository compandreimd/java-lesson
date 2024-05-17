import sys
if len(sys.argv) > 1:
    s = sys.argv[1]
else:
    s = input("Choose Class (Andrei, DemoStart, Main, Vars, Operation, HW1):?")

if s == "Andrei":
    import Andrei
elif s == "Vars":
    import vars.DemoVars as DemoVars
    demo = DemoVars
    demo.demo()
elif s == "DemoStart":
    import DemoStart
elif s == "Operation":
    from oper.Operation import calc
    calc()
elif s == "Main" or s == "HW1":
    import homework.HW1 as HW1
    HW1.Media()
else:
    print(f"Not such class {s}")
