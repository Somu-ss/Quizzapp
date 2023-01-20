package com.example.quizz

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_QUESTIONS: String = "correct_questions"

    fun getQuestions(): ArrayList<Questions> {
        val questionList = ArrayList<Questions>()

        val ques1 = Questions(
            1 ,
            "which this flag belongs to?",
            R.drawable.indian_flag,"India",
            "America","Argentina",
            "United Kingdom",1

        )
        questionList.add(ques1)

        val ques2 = Questions(
            2 ,
            "which animal is this?",
            R.drawable.lion_img,"Tiger",
            "Lion","Leopard",
            "Dog",2

        )
        questionList.add(ques2)

        val ques3 = Questions(
            3 ,
            "which this flag belongs to?",
            R.drawable.uk_flag,"India",
            "America","argentina",
            "united kingdom",4

        )
        questionList.add(ques3)

        val ques4 = Questions(
            4,
            "which the flag belongs to?",
            R.drawable.america_flag,"India",
            "America","Argentina",
            "United Kingdom",2

        )
        questionList.add(ques4)

        val ques5 = Questions(
            5 ,
            "which the flag belongs to?",
            R.drawable.argentina_flag,"India",
            "America","Argentina",
            "United Kingdom",3

        )
        questionList.add(ques5)

        val ques6 = Questions(
            6 ,
            "which animal is this?",
            R.drawable.tiger_img,"Tiger",
            "Lion","Leopard",
            "Dog",1

        )
        questionList.add(ques6)

        val ques7 = Questions(
            7 ,
            "which animal is this?",
            R.drawable.leopard_img,"Tiger",
            "Lion","Leopard",
            "Dog",3

        )
        questionList.add(ques7)

        val ques8 = Questions(
            8 ,
            "which animal is this?",
            R.drawable.dog_img,"Tiger",
            "Lion","Leopard",
            "Dog",4

        )
        questionList.add(ques8)

        return questionList

    }
}