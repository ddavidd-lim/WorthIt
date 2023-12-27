from PIL import Image
import pytesseract

# pytesseract.pytesseract.tesseract_cmd = r"C:\Program Files\Tesseract-OCR\tesseract.exe"
img_file = "olivegarden2.jpg"

ocr_result = pytesseract.image_to_string(img_file)

print(ocr_result)