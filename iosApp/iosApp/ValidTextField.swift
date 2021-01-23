//
//  ValidButton.swift
//  iosApp
//
//  Created by Marek Mościchowski on 23/01/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI

struct ValidTextField: View {
  @Binding var first: String;
  @Binding var validError: String;
  var onLostFocus: (() -> Void)?
//  init(validError: String) {
//    self.validError = validError
//  }
    var body: some View {
      VStack {
        TextField("x", text: $first, onEditingChanged: { (editingChanged) in
          if !editingChanged {
            onLostFocus?()
          }
        }
          )
        Text(validError).foregroundColor(.red)
      }
        
    }
}
//
//struct ValidButton_Previews: PreviewProvider {
//    static var previews: some View {
//        ValidTextField(validError: "")
//    }
//}
