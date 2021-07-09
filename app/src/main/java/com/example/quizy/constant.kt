package com.example.quizy

object constant {

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTION:String =  "10"
    const val CORRECT_ANSWER:String = "7"

    fun getQuestions(): ArrayList<Questions> {
        val questionsList = ArrayList<Questions>()

        val que1 = Questions(
            1, "What country this flag belongs to?",
            R.drawable.ic_flag_of_argentina, "Austria", "Armenia",
            "Argentina", "Afghanistan",
            3)

        questionsList.add(que1)


        val que2 = Questions(
            1, "What country this flag belongs to?",
            R.drawable.ic_flag_of_australia, "Australia", "America",
            "United Kingdom", "France",
            1)

        questionsList.add(que2)


        val que3 = Questions(
            1, "What country this flag belongs to?",
            R.drawable.ic_flag_of_belgium, "Russia", "Denmark",
            "Nigeria", "Belgium",
            4)

        questionsList.add(que3)


        val que4 = Questions(
            1, "What country this flag belongs to?",
            R.drawable.ic_flag_of_brazil, "Azerbaijan", "Brazil",
            "Cambodia", "Spain",
            2)

        questionsList.add(que4)


        val que5 = Questions(
            1, "What country this flag belongs to?",
            R.drawable.ic_flag_of_denmark, "Switzerland", "Norway",
            "New Zealand", "Denmark",
            4)

        questionsList.add(que5)


        val que6 = Questions(
            1, "What country this flag belongs to?",
            R.drawable.ic_flag_of_fiji, "Fiji", "Belarus",
            "Thailand", "Bangkok",
            1)

        questionsList.add(que6)


        val que7 = Questions(
            1, "What country this flag belongs to?",
            R.drawable.ic_flag_of_germany, "Germany", "Greenland",
            "Argentina", "Afghanistan",
            1)

        questionsList.add(que7)
        val que8 = Questions(
            1, "What country this flag belongs to?",
            R.drawable.ic_flag_of_india, "India", "Bangladesh",
            "Srilanka", "Myanmmar",
            1)

        questionsList.add(que8)


        val que9 = Questions(
            1, "What country this flag belongs to?",
            R.drawable.ic_flag_of_kuwait, "UAE", "Kuwait",
            "Saudi Arab", "Afghanistan",
            2)

        questionsList.add(que9)


        val que10 = Questions(
            1, "What country this flag belongs to?",
            R.drawable.ic_flag_of_new_zealand, "Austria", "Armenia",
            "Argentina", "New Zealand",
            4)

        questionsList.add(que10)

        return questionsList
    }
}