# Calorie

Finding the most cost-efficient food in restaurants

## Overview

The app uses the Nutritionix API to fetch nutritional information for different branded foods and calculates the dollar per calorie value based on their prices.
The app will also use OCR to scan menu images and parse the information to get these price values if calorie info is present

### To-Do List
- [ ] Use OCR and NER to process and clean image before converting to text with Pytesseract
- [ ] Convert text to JSON to send to backend
- [ ] Create API to send JSON to backend
- [ ] Create backend to process all menu items in JSON format and respond with list of menu items sorted by calories/dollar
- [ ] Create frontend website with camera functionality to send image taken to backend with API


### Feature List
- [ ] Price tracker to view prices over time
- [ ] Cost goals
- [ ] Using camera to scan menu
- [ ] can sort from highest to lowest value
- [ ] Using different nutritional values
