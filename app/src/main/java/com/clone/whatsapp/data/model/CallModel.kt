package com.clone.whatsapp.data.model

class CallModel {

    companion object {
        val callContactDetails = listOf(
            CallContactDetails(
                "Aron",
                "https://cdn.pixabay.com/photo/2019/09/02/05/12/girl-4446528_640.jpg",
                "Fri Apr 05 13:18:11 GMT+05:30 2024",
                1,
                1
            ),
            CallContactDetails(
                "Abelson",
                "https://cdn.pixabay.com/photo/2019/09/02/05/12/girl-4446528_640.jpg",
                "Fri Apr 05 13:18:11 GMT+05:30 2024",
                1,
                0
            ),
            CallContactDetails(
                "Cathor",
                "https://cdn.pixabay.com/photo/2019/07/29/08/57/girl-4370196_640.jpg",
                "Fri Apr 05 13:18:11 GMT+05:30 2024",
                0,
                1
            ),
            CallContactDetails(
                "Steven",
                "https://cdn.pixabay.com/photo/2019/07/30/04/28/girl-4371910_640.jpg",
                "Fri Apr 05 13:18:11 GMT+05:30 2024",
                1,
                1
            ),
            CallContactDetails(
                "Steven",
                "https://cdn.pixabay.com/photo/2019/07/30/04/28/girl-4371910_640.jpg",
                "Fri Apr 05 13:18:11 GMT+05:30 2024",
                1,
                0
            ),
            CallContactDetails(
                "Henry Ward",
                "https://cdn.pixabay.com/photo/2020/06/07/07/03/girl-5269312_640.jpg",
                "Fri Apr 05 13:18:11 GMT+05:30 2024",
                0,
                0
            ),
            CallContactDetails(
                "Jacob Jones",
                "https://cdn.pixabay.com/photo/2019/12/26/08/22/girl-4719899_640.jpg",
                "Fri Apr 05 13:18:11 GMT+05:30 2024",
                0,
                0
            ),
            CallContactDetails(
                "Lilly",
                "https://cdn.pixabay.com/photo/2019/08/13/05/39/girl-4402542_640.jpg",
                "Fri Apr 04 13:18:11 GMT+05:30 2024",
                1,
                1
            ),
            CallContactDetails(
                "Abelson",
                "https://cdn.pixabay.com/photo/2019/09/02/05/12/girl-4446528_640.jpg",
                "Fri Apr 05 13:18:11 GMT+05:30 2024",
                1,
                0
            ),
            CallContactDetails(
                "Cathor",
                "https://cdn.pixabay.com/photo/2019/07/29/08/57/girl-4370196_640.jpg",
                "Fri Apr 05 13:18:11 GMT+05:30 2024",
                0,
                1
            ),
            CallContactDetails(
                "Steven",
                "https://cdn.pixabay.com/photo/2019/07/30/04/28/girl-4371910_640.jpg",
                "Fri Apr 05 13:18:11 GMT+05:30 2024",
                1,
                1
            ),
            CallContactDetails(
                "Steven",
                "https://cdn.pixabay.com/photo/2019/07/30/04/28/girl-4371910_640.jpg",
                "Fri Apr 05 13:18:11 GMT+05:30 2024",
                1,
                0
            ),
            CallContactDetails(
                "Henry Ward",
                "https://cdn.pixabay.com/photo/2020/06/07/07/03/girl-5269312_640.jpg",
                "Fri Apr 05 13:18:11 GMT+05:30 2024",
                0,
                0
            ),
            CallContactDetails(
                "Jacob Jones",
                "https://cdn.pixabay.com/photo/2019/12/26/08/22/girl-4719899_640.jpg",
                "Fri Apr 05 13:18:11 GMT+05:30 2024",
                0,
                0
            ),
            CallContactDetails(
                "Lilly",
                "https://cdn.pixabay.com/photo/2019/08/13/05/39/girl-4402542_640.jpg",
                "Fri Apr 04 13:18:11 GMT+05:30 2024",
                1,
                1
            )


        )
    }

    data class CallContactDetails(
        val name: String,
        val profilePicture: String,
        val date: String,
        val callType1: Int,
        val callType2: Int
    )
}
