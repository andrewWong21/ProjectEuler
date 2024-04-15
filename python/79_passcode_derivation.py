def passcode_derivation(codes: list) -> str:
    
    # build graph of outgoing edges
    graph = {}

    for code in codes:
        for digit in code:
            if digit not in graph:
                graph[digit] = set()
        
        # create outgoing edge from each digit in code to all subsequent digits
        for i in range(0, 3):
            for j in range(i + 1, 3):
                graph[code[i]].add(code[j])
    
    # sort list of digits by outgoing degree of graph, descending
    # naive approach that works for passcode with non-repeating digits
    digits = sorted(list(graph.keys()), key=lambda x: -len(graph[x]))
    return "".join(digits)

if __name__ == "__main__":
    f = open("79_keylog.txt")
    codes = f.read().split()
    f.close()
    
    print(passcode_derivation(codes))
