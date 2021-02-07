from PIL import Image

image = Image.open('7fe3c3f6-Stego.png')

extracted = ''

pixels = image.load()
for z in range(0, image.height):
    for x in range(0, image.width):
        r, g, b, a = pixels[x, z]
        extracted += bin(b)[-1]

chars = []
for i in range(int(len(extracted)/8)):
    byte = extracted[i*8:(i+1)*8][::-1]
    if byte == '00000000':
        break
    chars.append(chr(int(''.join([str(bit) for bit in byte]), 2)))

secret = ''.join(chars)
print(secret)
