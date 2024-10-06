<h1>Stock App</h1>
Welcome to the Stock App! This application allows users to search for stock information using the Yahoo Finance API provided by RapidAPI.

<h2>Features</h2>
<ul>
  <li>Search for stock data using a stock ticker symbol.</li>
  <li>Real-time stock data display (fetched via the Yahoo Finance API).</li>
  <li>Simple, easy-to-use UI built with Jetpack Compose.</li>
</ul>
<h2>Requirements</h2>
To run this app, you'll need:
<ul>
  <li>Android Studio (latest version recommended).</li>
  <li>A RapidAPI account.</li>
  <li>An API key for the Yahoo Finance API from RapidAPI.</li>
</ul>

<h2>Getting Started</h2>
<h3>1. Clone the repository</h3>
First, clone this repository to your local machine:<br>
git clone https://github.com/yourusername/stock-app.git

<h3>2. Get an API Key from RapidAPI</h3>
<ul>
  <li>Go to Yahoo Finance API on RapidAPI.</li>
  <li>Sign up or log in to your RapidAPI account.</li>
  <li>Subscribe to the API and get your API key.</li>
</ul>

<h3>3. Set the API Key</h3>
Once you have your API key from RapidAPI, follow these steps:
<ul>
  <li>Open the project in Android Studio.</li>
  <li>Locate the gradle.properties file (found in the root directory or in android/gradle.properties).</li>
  <li>Add your API key to the API_KEY property:</li>
</ul>
<b>API_KEY="YOUR_API_KEY_HERE"</b> <br>
Make sure to replace <b><i>YOUR_API_KEY_HERE</i></b> with your actual API key.

<h3>4. Build and Run the App</h3>
Now, you can build and run the app using Android Studio:
<ul>
  <li>Open Android Studio.</li>
  <li>Select Build > Make Project to ensure everything is correctly configured.</li>
  <li>Select Run to install the app on your emulator or physical device.</li>
</ul>

<h3>5. Usage</h3>
Once the app is running:
<ul>
  <li>Enter a stock ticker symbol (e.g., AAPL for Apple, GOOGL for Alphabet).</li>
  <li>Press "Search" to fetch and display the stock data.</li>
</ul>

<h2>Tech Stack</h2>
<ul>
  <li><b>Kotlin</b>: Primary programming language.</li>
  <li><b>Jetpack Compose</b>: UI framework for building native Android interfaces.</li>
  <li><b>Retrofit</b>: For handling API calls.</li>
  <li><b>Yahoo Finance API (via RapidAPI)</b>: For fetching real-time stock data. <a href="https://rapidapi.com/rphrp1985/api/yahoo-finance160">API</a></li>
</ul>

<h2>Acknowledgments</h2>
<ul>
  <li>Thanks to RapidAPI for providing the Yahoo Finance API.</li>
  <li>The Yahoo Finance API provides stock data, quotes, historical data, and more.</li>
</ul>
