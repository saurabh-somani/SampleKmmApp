import SwiftUI
import shared
import Kingfisher

struct ContentView: View {
    
    @StateObject private var viewModel = ContentViewModel(mainRepo: MainRepoImpl())
    
	let greet = Greeting().greeting()

	var body: some View {
//		Text(greet)
        if (viewModel.url != nil) {
//            Text(viewModel.url ?? "Sample text")
            KFImage(URL(string: viewModel.url ?? "")!)
                .resizable()
                .aspectRatio(contentMode: .fit)
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
