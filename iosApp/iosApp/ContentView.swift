import SwiftUI
import shared

func greet() -> String {
    return Greeting().greeting()
}

class ViewData: ObservableObject, LoginUI {
  var loginLostFocus: (() -> Void)?
  var passLostFocus: (() -> Void)?
  var loginAction: (() -> Void)?
  
  var login: String = ""
  var pass: String = ""
  
  @Published var loginValidError: String = ""
  @Published var passValidError: String = ""
  @Published var alert: String = ""
  @Published var loginButtonEnabled: Bool = false
}

struct ContentView: View {
  
  private var bindableIsVisibleError: Binding<Bool> { Binding (
      get: { self.model.alert != "" },
      set: { if !$0 { self.model.alert = "" } }
      )
  }
  
  @ObservedObject var model: ViewData
//  var input: Input
  
    var body: some View {
      VStack {
        Text(model.loginValidError)
        ValidTextField(first: $model.login, validError: $model.loginValidError, onLostFocus: model.loginLostFocus)
        ValidTextField(first: $model.pass, validError: $model.passValidError, onLostFocus: model.passLostFocus)
        Button("Login") {
          model.loginAction?()
        }.disabled(!model.loginButtonEnabled)
      }.alert(isPresented: bindableIsVisibleError) {
        Alert(title: Text(model.alert), message: Text("placeholder"), dismissButton: .default(Text("Got it!")))
    }
      
  }
}

//struct ContentView_Previews: PreviewProvider {
//    static var previews: some View {
//      ContentView()
//    }
//}
