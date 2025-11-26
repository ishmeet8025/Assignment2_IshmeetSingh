# Assignment 2 – Multi-Activity Android App  
**Course:** MAD204 – Java/Kotlin Development for Mobile Applications  
**Student:** Ishmeet Singh  
**College:** Canadore College  

---

## Overview  
This Android application demonstrates the following core Android concepts:

- Multi-activity navigation  
- User login and registration  
- SharedPreferences data storage  
- Activity lifecycle logging  
- RecyclerView list with click, delete & swipe actions  
- Settings screen  
- Profile editing using dialogs  
- Material UI components  

---

## Application Flow  

### **1. Login Screen (MainActivity)**  
- Email + Password fields  
- Validation included  
- Successful login saves user email to SharedPreferences  
- Button to navigate to Registration screen  

### **2. Registration Screen**  
- Fields: Name, Email, Age, Program  
- Input validation  
- Saves data in SharedPreferences  
- Returns to Login screen  

### **3. Dashboard Screen**  
- Displays Welcome message  
- Buttons: Profile, Countries List, Settings  
- Logout button clears SharedPreferences  
- Lifecycle logs shown in Logcat  

### **4. Profile Screen**  
- Shows user information  
- Edit Profile button opens a dialog  
- Allows updating SharedPreferences values  

### **5. Countries List (RecyclerView)**  
- Displays list of countries  
- Click: show toast  
- Swipe left: delete  
- Delete has Undo snackbar  

### **6. Settings Screen**  
- Dummy options  
- Dark mode toggle (optional)  

---

## Technologies Used  
- **Kotlin**  
- **Android Studio (Hedgehog/Koala)**  
- **RecyclerView**  
- **AlertDialog**  
- **SharedPreferences**  
- **Material Components**  
