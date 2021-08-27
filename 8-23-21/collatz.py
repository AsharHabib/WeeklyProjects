def collatz(a, b):
    if collatz_steps(a) < collatz_steps(b):
        print("a")
    else:
        print("b")
    
def collatz_steps(num):
    steps = 0
    while num != 1:
        if num % 2 == 0:
            num = num//2
        else:
            num = 3 * num + 1
        steps += 1
    return steps
  
collatz(13, 16)
collatz(53782, 72534)
