package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Question

class QuestionRepository {

    fun getQuestions(
        subjectId: String,
        chapterId: String
    ): List<Question> {

        return when (chapterId) {

            "accounting_for_partnership" -> listOf(
                Question(
                    id = "acc_001",
                    question = "Partnership deed is a document containing the terms and conditions agreed upon by the partners.",
                    options = listOf(
                        "True",
                        "False",
                        "Only for companies",
                        "Only for banks"
                    ),
                    correctAnswer = 0,
                    explanation = "A partnership deed contains the terms and conditions mutually agreed upon by the partners.",
                    subjectId = subjectId,
                    chapterId = chapterId
                ),
                Question(
                    id = "acc_002",
                    question = "In the absence of an agreement, partners generally share profits and losses in:",
                    options = listOf(
                        "Equal ratio",
                        "Capital ratio",
                        "Sales ratio",
                        "Current account ratio"
                    ),
                    correctAnswer = 0,
                    explanation = "In the absence of an agreement, profits and losses are shared equally.",
                    subjectId = subjectId,
                    chapterId = chapterId
                ),
                Question(
                    id = "acc_003",
                    question = "Interest on partner's capital is allowed only when it is provided by:",
                    options = listOf(
                        "Partnership agreement",
                        "Bank",
                        "Government",
                        "Customer"
                    ),
                    correctAnswer = 0,
                    explanation = "Interest on capital is allowed according to the terms of the partnership agreement.",
                    subjectId = subjectId,
                    chapterId = chapterId
                ),
                Question(
                    id = "acc_004",
                    question = "The account prepared to distribute profits among partners is called:",
                    options = listOf(
                        "Profit and Loss Appropriation Account",
                        "Cash Account",
                        "Sales Account",
                        "Purchase Account"
                    ),
                    correctAnswer = 0,
                    explanation = "The Profit and Loss Appropriation Account shows the distribution of profit among partners.",
                    subjectId = subjectId,
                    chapterId = chapterId
                ),
                Question(
                    id = "acc_005",
                    question = "A partner is an agent of:",
                    options = listOf(
                        "The firm",
                        "The bank",
                        "The government",
                        "Customers only"
                    ),
                    correctAnswer = 0,
                    explanation = "Every partner is an agent of the firm for the purpose of its business.",
                    subjectId = subjectId,
                    chapterId = chapterId
                )
            )

            "nature_significance_management" -> listOf(
                Question(
                    id = "bst_001",
                    question = "Management is the process of getting things done through and with people.",
                    options = listOf(
                        "True",
                        "False",
                        "Only partly true",
                        "None of these"
                    ),
                    correctAnswer = 0,
                    explanation = "Management involves getting work done through and with people to achieve organisational objectives.",
                    subjectId = subjectId,
                    chapterId = chapterId
                ),
                Question(
                    id = "bst_002",
                    question = "Which function of management involves setting objectives?",
                    options = listOf(
                        "Planning",
                        "Staffing",
                        "Directing",
                        "Controlling"
                    ),
                    correctAnswer = 0,
                    explanation = "Planning involves setting objectives and deciding the course of action to achieve them.",
                    subjectId = subjectId,
                    chapterId = chapterId
                )
            )

            "national_income_accounting" -> listOf(
                Question(
                    id = "eco_001",
                    question = "GDP stands for:",
                    options = listOf(
                        "Gross Domestic Product",
                        "General Domestic Product",
                        "Gross Development Product",
                        "General Development Price"
                    ),
                    correctAnswer = 0,
                    explanation = "GDP means Gross Domestic Product.",
                    subjectId = subjectId,
                    chapterId = chapterId
                ),
                Question(
                    id = "eco_002",
                    question = "National income is generally measured over a period of:",
                    options = listOf(
                        "One year",
                        "One day",
                        "One week",
                        "One month only"
                    ),
                    correctAnswer = 0,
                    explanation = "National income is a flow concept and is generally measured over a period of one year.",
                    subjectId = subjectId,
                    chapterId = chapterId
                )
            )

            "matrices" -> listOf(
                Question(
                    id = "math_001",
                    question = "A matrix having the same number of rows and columns is called:",
                    options = listOf(
                        "Square matrix",
                        "Row matrix",
                        "Column matrix",
                        "Zero matrix"
                    ),
                    correctAnswer = 0,
                    explanation = "A matrix with equal numbers of rows and columns is called a square matrix.",
                    subjectId = subjectId,
                    chapterId = chapterId
                ),
                Question(
                    id = "math_002",
                    question = "A matrix having all its elements equal to zero is called:",
                    options = listOf(
                        "Zero matrix",
                        "Identity matrix",
                        "Unit matrix",
                        "Diagonal matrix"
                    ),
                    correctAnswer = 0,
                    explanation = "A matrix in which every element is zero is called a zero matrix.",
                    subjectId = subjectId,
                    chapterId = chapterId
                )
            )

            else -> listOf(
                Question(
                    id = "demo_001",
                    question = "COMMERZO practice question is ready. What should you do after selecting an answer?",
                    options = listOf(
                        "Submit the answer",
                        "Close the app",
                        "Delete the question",
                        "Skip the entire subject"
                    ),
                    correctAnswer = 0,
                    explanation = "Select an option and press Submit to check your answer.",
                    subjectId = subjectId,
                    chapterId = chapterId
                ),
                Question(
                    id = "demo_002",
                    question = "What does COMMERZO focus on?",
                    options = listOf(
                        "Learning and practice",
                        "Only entertainment",
                        "Only chatting",
                        "Only video editing"
                    ),
                    correctAnswer = 0,
                    explanation = "COMMERZO is being built as a learning, practice and test platform.",
                    subjectId = subjectId,
                    chapterId = chapterId
                )
            )
        }
    }
}
