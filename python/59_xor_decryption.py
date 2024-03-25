def xor_decryption(encrypted: list) -> int:
    
    plaintext = decrypt(encrypted)[1]
    # print(decrypt(encrypted)[0])
    # print(plaintext)
    return sum(ord(chr) for chr in plaintext)
    
def decrypt(encrypted: list) -> tuple:
    for a in range (97, 123):
        for b in range(97, 123):
            for c in range(97, 123):
                key = chr(a) + chr(b) + chr(c)
                decrypted = ""
                for i in range(0, len(encrypted)):
                    decrypted += chr(encrypted[i] ^ ord(key[i % 3]))
                
                # check if output is intelligible
                if " the " in decrypted:
                    return (key, decrypted)
    return ("", "")

if __name__ == "__main__":
    f = open("59_cipher.txt", 'r')
    encrypted = [int(num) for num in f.read().strip().split(',')]
    f.close()
    
    print(xor_decryption(encrypted))