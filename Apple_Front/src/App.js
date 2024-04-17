import { BrowserRouter } from "react-router-dom";

import Header from "./app/Header"
import Nav from "./app/Nav"
import Main from "./app/Main"
import Footer from "./app/Footer"
import AuthProvider from "./context/AuthProvider"
import HttpHeadersProvider from "./context/HttpHeadersProvider";
import "./css/style.css"

function App() {

  return (
    <div>
      <BrowserRouter>
        
        <Header />
        
        <AuthProvider>
          <HttpHeadersProvider>
            <Nav />
            <Main />
          </HttpHeadersProvider>
        </AuthProvider>

        <Footer />

      </BrowserRouter>
    </div>
  );
}

export default App;
