# WorthIt

Finding the most cost-efficient food in restaurants

## Overview

This is a web-app that will use OCR to scan a menu and create entities for each item which contain a food's name, calorie count, and price. It will then organize each item on the menu in a list that is sorted by the highest calorie/dollar, which is defined as the cost efficiency of a food.
The app uses the Nutritionix API to fetch nutritional information for different branded foods and can fill in missing information such as calories. This API can help scale the app with the nutritional information it gives and features such as sorting by certain nutritional values can be implemented in the future.

## Download Packages
- Download Python 3.10
- Windows: pip install virtualenv
- Create virtual environment with $virtualenv *venv* --python=*3.10*
- $.\venv\Scripts\activate
- $pip install -r requirements.txt

### To-Do List
- [ ] Use OCR and NER to process and clean image before converting to text with Pytesseract
- [ ] Convert text to JSON to send to backend
- [ ] Create API to send JSON to backend
- [ ] Create backend to process all menu items in JSON format and respond with list of menu items sorted by calories/dollar
- [ ] Create frontend website with camera functionality to send image taken to backend with API
- [ ] Implement google translate live camera functionality
- [ ] Store JSONs into database with timestamp for price tracker
- [ ] QR code support


### Feature List
- [ ] Price tracker to view prices over time
- [ ] Cost goals
- [ ] Using camera to scan menu
- [ ] can sort from highest to lowest value
- [ ] Using different nutritional values
