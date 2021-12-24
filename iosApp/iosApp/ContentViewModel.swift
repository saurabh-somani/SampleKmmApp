//
//  ContentViewModel.swift
//  iosApp
//
//  Created by Saurabh Somani on 24/12/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class ContentViewModel : ObservableObject {
    
    private var mainRepo : MainRepo
    @Published var url: String?
    @Published var showProgress = false
    
    init(mainRepo: MainRepo) {
        self.mainRepo = mainRepo
        fetchData()
    }
    
    func fetchData() {
        self.showProgress = true
        mainRepo.getImageUrls { data, error in
            if let url = data {
                self.url = url.first
            }
            self.showProgress = false
        }
    }
}
