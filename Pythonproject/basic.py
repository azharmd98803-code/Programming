import pandas as pd
import streamlit as st
import matplotlib.pyplot as plt
import seaborn as sns

from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_absolute_error, r2_score

st.set_page_config(page_title="Student Performance Analytics", layout="centered")

st.title("🎓 Student Performance Analytics System")

# -------------------
# Load Dataset
# -------------------
@st.cache_data
def load_data():
    return pd.read_csv("student.csv")


try:
    data = load_data()
    st.success("Dataset Loaded Successfully!")
except:
    st.error("student.csv not found! Keep it in same folder as app.py")
    st.stop()

# -------------------
# Sidebar Menu
# -------------------
menu = st.sidebar.selectbox(
    "Select Option",
    [
        "Dataset Info",
        "Clean Data",
        "Statistical Summary",
        "Visualizations",
        "Train Model",
        "Predict Marks",
    ],
)

# -------------------
# Dataset Info
# -------------------
if menu == "Dataset Info":
    st.subheader("Dataset Preview")
    st.write(data.head())

    st.subheader("Dataset Info")
    st.text(str(data.info()))

# -------------------
# Clean Data
# -------------------
elif menu == "Clean Data":
    st.subheader("Before Cleaning")
    st.write(data)

    clean_data = data.dropna()

    st.subheader("After Cleaning")
    st.write(clean_data)

# -------------------
# Statistical Summary
# -------------------
elif menu == "Statistical Summary":
    st.subheader("Statistical Summary")
    st.write(data.describe())

# -------------------
# Visualizations
# -------------------
elif menu == "Visualizations":
    st.subheader("Visualizations")

    graph = st.selectbox(
        "Choose Graph",
        ["Study Hours vs Marks", "Attendance vs Marks", "Correlation Heatmap"],
    )

    if graph == "Study Hours vs Marks":
        fig, ax = plt.subplots()
        sns.scatterplot(x="study_hours", y="marks", data=data, ax=ax)
        st.pyplot(fig)

    elif graph == "Attendance vs Marks":
        fig, ax = plt.subplots()
        sns.scatterplot(x="attendance", y="marks", data=data, ax=ax)
        st.pyplot(fig)

    elif graph == "Correlation Heatmap":
        fig, ax = plt.subplots()
        sns.heatmap(data.corr(numeric_only=True), annot=True, ax=ax)
        st.pyplot(fig)

# -------------------
# Train Model
# -------------------
elif menu == "Train Model":
    st.subheader("Train ML Model")

    X = data[["study_hours", "attendance", "previous_score"]]
    y = data["marks"]

    X_train, X_test, y_train, y_test = train_test_split(
        X, y, test_size=0.2, random_state=42
    )

    model = LinearRegression()
    model.fit(X_train, y_train)

    preds = model.predict(X_test)

    st.success("Model Trained Successfully!")
    st.write("MAE:", mean_absolute_error(y_test, preds))
    st.write("R2 Score:", r2_score(y_test, preds))

    st.session_state["model"] = model

# -------------------
# Prediction
# -------------------
elif menu == "Predict Marks":
    st.subheader("Predict Student Marks")

    if "model" not in st.session_state:
        st.warning("Please train the model first!")
    else:
        study_hours = st.number_input("Study Hours", min_value=0.0)
        attendance = st.number_input("Attendance %", min_value=0.0)
        previous_score = st.number_input("Previous Score", min_value=0.0)

        if st.button("Predict"):
            input_df = pd.DataFrame(
                [[study_hours, attendance, previous_score]],
                columns=["study_hours", "attendance", "previous_score"],
            )

            result = st.session_state["model"].predict(input_df)
            st.success(f"Predicted Marks: {result[0]:.2f}")

st.markdown("---")
st.markdown("### ✅ Thank you for using the system 😊")