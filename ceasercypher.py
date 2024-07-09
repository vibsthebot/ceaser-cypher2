
def convert(s):
    new = ""
    for x in s:
        new += x
    return new

eord = int(input("Encryption or Decryption? 1 for Encryption, 2 for Decryption"))
AlphabetArray = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9']

if eord == 1:
  plaintext = input('Type your plaintext:')
  key = int(input("Type your key:"))
  charArray = list(plaintext)
  length = len(charArray)
  finalArray = []
  i = 0
  while i<length:
    index = AlphabetArray.index(charArray[i]) + key
    if (index>35 or index<0):
      if (index>35):
        index = index-35
      else: index = index+35
    finalArray.append(AlphabetArray[index])
    i=i+1
  print(convert(finalArray))
elif eord == 2:
  ciphertext = input('Type your ciphertext:')
  key = int(input("Type your key:"))
  charArray = list(ciphertext)
  length = len(charArray)
  finalArray = []
  i = 0
  while i<length:
    index = AlphabetArray.index(charArray[i]) - key
    if (index>35 or index<0):
      if (index>35):
        index = index-35
      else: index = index+35
    finalArray.append(AlphabetArray[index])
    i=i+1
  print(convert(finalArray))