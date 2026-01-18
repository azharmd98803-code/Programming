import pandas as pd
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression

# ---------------------------
# Load Dataset
# ---------------------------
data = pd.read_csv("patient_data.csv")
data = data.dropna()

# ---------------------------
# Train Model
# ---------------------------
X = data[["age", "bp", "sugar", "cholesterol"]]
y = data["disease"]

X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.2, random_state=1
)

model = LogisticRegression()
model.fit(X_train, y_train)

# ---------------------------
# Helper
# ---------------------------
def pause():
    input("\nThank you 😊  Press Enter to continue...")

# ---------------------------
# Functions
# ---------------------------

def show_data():
    print("\n--- Patient Data (First 10 Records) ---\n")
    print(data.head(10))
    pause()

def show_statistics():
    print("\n--- Statistical Summary ---\n")
    print(data.describe())
    pause()

def show_graphs():
    plt.figure()
    plt.hist(data["age"], bins=8)
    plt.title("Age Distribution of Patients")
    plt.xlabel("Age")
    plt.ylabel("Count")
    plt.show()

    plt.figure()
    plt.boxplot([data[data["disease"] == 0]["sugar"],
                 data[data["disease"] == 1]["sugar"]],
                labels=["No Disease", "Disease"])
    plt.title("Sugar Level vs Disease")
    plt.ylabel("Sugar Level")
    plt.show()

    pause()

def predict_disease():
    print("\n--- Enter Patient Details ---")
    age = int(input("Age: "))
    bp = int(input("Blood Pressure: "))
    sugar = int(input("Sugar Level: "))
    chol = int(input("Cholesterol: "))

    new_patient = [[age, bp, sugar, chol]]
    result = model.predict(new_patient)

    if result[0] == 1:
        print("\nDisease Risk: YES ⚠️")
    else:
        print("\nDisease Risk: NO ✅")

    pause()

# ---------------------------
# MENU
# ---------------------------

while True:
    print("\n====== PATIENT HEALTH ANALYSIS SYSTEM ======")
    print("1. View Patient Data")
    print("2. View Statistics")
    print("3. Show Graphs")
    print("4. Predict Disease Risk")
    print("5. Exit")

    choice = input("Enter your choice (1-5): ")

    if choice == "1":
        show_data()

    elif choice == "2":
        show_statistics()

    elif choice == "3":
        show_graphs()

    elif choice == "4":
        predict_disease()

    elif choice == "5":
        print("\nThank you for using the system 🙏😊")
        break

    else:
        print("\nInvalid choice! Please try again.")
        pause()