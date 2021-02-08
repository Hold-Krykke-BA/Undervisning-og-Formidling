from PIL import Image

image = Image.open('7fe3c3f6-Stego.png')
pixels = image.load()

extracted = ''
for i in range(0, image.height): 
    for j in range(0, image.width): 
        r, g, b, a = pixels[j, i] # (x, y)
        extracted += bin(b)[-1] # extract binary (LSB?)

secret = ''
for i in range(int(len(extracted)/8)): # for every 8th entry...
    byte = extracted[i*8:(i+1)*8][::-1] # get 8-bit (byte) combination at index + 8. Reverse for actual order. (LSB?)
    if byte == '00000000':
        break
    secret += chr(int(byte, 2)) #convert byte to integer from base-2 (binary), then finally to char for string representation.

print(secret) 
# Congratulations, this is the secret message of the UFO class! (no, not 42)