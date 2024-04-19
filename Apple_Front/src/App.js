import { BrowserRouter } from "react-router-dom";

import Header from "./common/Header"
import Main from "./common/Main"
import Footer from "./common/Footer"
import AuthProvider from "./context/AuthProvider"
import HttpHeadersProvider from "./context/HttpHeadersProvider";



function App() {

  return (
    <div>
      <BrowserRouter>
        
        <Header />
        
        <AuthProvider>
          <HttpHeadersProvider>
            <Main />
          </HttpHeadersProvider>
        </AuthProvider>

        <Footer />

      </BrowserRouter>
    </div>
  );
}

export default App;
