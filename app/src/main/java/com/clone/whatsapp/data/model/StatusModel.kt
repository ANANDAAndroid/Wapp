package com.clone.whatsapp.data.model

class StatusModel {

    companion object {
        val statusContactList = listOf(
            StatusContactDetails(
                "Abelson",
                "https://cdn.pixabay.com/photo/2021/06/15/16/11/man-6339003_640.jpg",
                "Fri Apr 05 13:40:11 GMT+05:30 2024",
                false
            ),
            StatusContactDetails(
                "Cathor",
                "https://cdn.pixabay.com/photo/2021/03/27/19/25/alone-boy-6129399_640.jpg",
                "Fri Apr 05 13:18:11 GMT+05:30 2024",
                false
            ),
            StatusContactDetails(
                "Steven",
                "https://cdn.pixabay.com/photo/2020/07/16/14/50/alone-boy-5411144_640.jpg",
                "Fri Apr 05 13:18:11 GMT+05:30 2024",
                false
            )
            ,
            StatusContactDetails(
                "Franklin",
                "https://cdn.pixabay.com/photo/2019/06/03/05/07/portrait-4248098_640.jpg",
                "Fri Apr 04 13:18:11 GMT+05:30 2024",
                true
            ),
            StatusContactDetails(
                "Henry Ward",
                "https://cdn.pixabay.com/photo/2020/05/17/20/21/cat-5183427_1280.jpg",
                "Fri Apr 04 13:18:11 GMT+05:30 2024",
                true
            ),
            StatusContactDetails(
                "Jacob Jones",
                "https://cdn.pixabay.com/photo/2014/04/12/14/59/portrait-322470_640.jpg",
                "Fri Apr 04 13:18:11 GMT+05:30 2024",
                true
            )
        )
    }

    data class StatusContactDetails(
        val name: String,
        val profilePicture: String,
        val date: String,
        val view: Boolean
    )
}