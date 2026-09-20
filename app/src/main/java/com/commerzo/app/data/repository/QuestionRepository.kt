package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question
import com.commerzo.app.data.model.QuestionDifficulty

/**
 * MP Board Class 12 question bank.
 *
 * Accountancy, Business Studies and Economics Micro/Macro questions are sourced
 * from the supplied COMMERZO master MCQ document and interleaved by difficulty
 * within each chapter. Hindi, English and Mathematics contain the requested
 * expanded chapter-wise generated practice set. Existing Economics IED legacy
 * questions are retained for chapter compatibility.
 */
class QuestionRepository {

    fun getQuestions(subjectId: String, chapterId: String, board: Board = Board.MP_BOARD, classLevel: ClassLevel = ClassLevel.CLASS_12): List<Question> =
        questionBank().filter { it.subjectId == subjectId && it.chapterId == chapterId && it.board == board && it.classLevel == classLevel }

    fun getQuestions(subjectId: String, chapterId: String): List<Question> =
        getQuestions(subjectId, chapterId, Board.MP_BOARD, ClassLevel.CLASS_12)

    private fun questionBank(): List<Question> = listOf(
        Question(
            id = "accountancy_class_12_1_m0001",
            question = "Partnership deed is primarily prepared to:",
            options = listOf(
                "Calculate sales",
                "Define rights and duties of partners",
                "Calculate market value of assets",
                "Determine cash balance"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0002",
            question = "A and B share profits in the ratio 3:2. The firm earns ₹50,000. B's share will be:",
            options = listOf(
                "₹20,000",
                "₹25,000",
                "₹30,000",
                "₹15,000"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0003",
            question = "A and B share profits in the ratio 3:2. Their capitals are ₹5,00,000 and ₹4,00,000. Interest on capital is 10% p.a. Profit before interest is ₹70,000. The amount of profit available after interest on capital is:",
            options = listOf(
                "₹20,000",
                "₹30,000",
                "₹40,000",
                "₹50,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0004",
            question = "In the absence of a partnership deed, profits and losses are shared:",
            options = listOf(
                "In capital ratio",
                "In old ratio",
                "Equally",
                "In current ratio"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0005",
            question = "P and Q have capitals of ₹4,00,000 and ₹3,00,000. The deed provides interest on capital @10% p.a. If profit is ₹50,000, total interest on capital is:",
            options = listOf(
                "₹50,000",
                "₹70,000",
                "₹40,000",
                "₹30,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0006",
            question = "A and B share profits 3:2. A is guaranteed a minimum profit of ₹36,000. Firm's profit is ₹50,000. A's normal share is ₹30,000. B bears the deficiency alone. B's share after guarantee will be:",
            options = listOf(
                "₹14,000",
                "₹16,000",
                "₹20,000",
                "₹24,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0007",
            question = "Interest on partner's capital is allowed only when:",
            options = listOf(
                "Firm earns profit",
                "Partnership deed provides for it",
                "Partner demands it",
                "Capital is fixed"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0008",
            question = "A withdraws ₹5,000 at the beginning of every month. For calculating interest on drawings, the average period is:",
            options = listOf(
                "5.5 months",
                "6 months",
                "6.5 months",
                "12 months"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0009",
            question = "A withdraws ₹8,000 at the beginning of each quarter. Interest on drawings is 10% p.a. The amount of interest on drawings is:",
            options = listOf(
                "₹2,400",
                "₹2,800",
                "₹3,000",
                "₹3,200"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0010",
            question = "In the absence of an agreement, interest on drawings is:",
            options = listOf(
                "Charged at 6%",
                "Charged at 10%",
                "Not charged",
                "Charged at bank rate"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0011",
            question = "A partner withdraws ₹10,000 at the end of every month. The average period for interest on drawings is:",
            options = listOf(
                "5.5 months",
                "6 months",
                "6.5 months",
                "12 months"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0012",
            question = "A withdraws ₹12,000 at the end of each quarter. Interest on drawings is 8% p.a. Interest on drawings will be:",
            options = listOf(
                "₹720",
                "₹960",
                "₹1,200",
                "₹1,440"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0013",
            question = "A partner's loan to the firm, in the absence of an agreement, carries interest at:",
            options = listOf(
                "5% p.a.",
                "6% p.a.",
                "8% p.a.",
                "No interest"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0014",
            question = "X and Y share profits equally. X is guaranteed ₹30,000. The firm's profit is ₹50,000. X's normal share is ₹25,000. The deficiency is:",
            options = listOf(
                "₹2,500",
                "₹5,000",
                "₹10,000",
                "Nil"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0015",
            question = "A and B share profits 3:2. A is guaranteed ₹40,000. The firm's profit is ₹60,000. The deficiency is borne by A himself. What amount will B receive?",
            options = listOf(
                "₹20,000",
                "₹24,000",
                "₹30,000",
                "₹36,000"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0016",
            question = "Interest on capital is an example of:",
            options = listOf(
                "Charge against profit",
                "Appropriation of profit",
                "Asset",
                "Liability towards outsiders"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0017",
            question = "A partner's capital is ₹2,00,000. Interest on capital is 8% p.a. The interest credited will be:",
            options = listOf(
                "₹8,000",
                "₹12,000",
                "₹16,000",
                "₹20,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0018",
            question = "A and B share profits 2:1. Profit before appropriations is ₹90,000. Interest on capital is ₹10,000 for A and ₹5,000 for B. A is also entitled to salary ₹15,000. Profit available for distribution after appropriations is:",
            options = listOf(
                "₹60,000",
                "₹70,000",
                "₹75,000",
                "₹90,000"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0019",
            question = "Interest on drawings is:",
            options = listOf(
                "Income for the firm",
                "Expense of the firm",
                "Asset of partner",
                "Loss on revaluation"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0020",
            question = "A and B share profits 5:3. C is guaranteed ₹12,000 as his minimum share. If C's actual share is ₹9,000 and A bears the deficiency alone, A's profit is reduced by:",
            options = listOf(
                "₹1,000",
                "₹2,000",
                "₹3,000",
                "₹4,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0021",
            question = "A and B share profits equally. A's drawings are ₹10,000 at the beginning of each month. B withdraws ₹20,000 at the end of each quarter. If interest is 6% p.a., the difference between their interest on drawings is:",
            options = listOf(
                "₹300",
                "₹450",
                "₹600",
                "₹750"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0022",
            question = "If a partner is guaranteed a minimum profit, the deficiency is generally borne by:",
            options = listOf(
                "All creditors",
                "The firm automatically",
                "The partner(s) specified in the guarantee",
                "Government"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0023",
            question = "If a partner withdraws ₹24,000 uniformly throughout the year, the average period for interest on drawings is generally:",
            options = listOf(
                "3 months",
                "6 months",
                "9 months",
                "12 months"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0024",
            question = "A and B share profits 3:2. A gets a salary of ₹20,000 and interest on capital of ₹10,000. B gets interest on capital of ₹5,000. Profit before these appropriations is ₹75,000. The residual profit is:",
            options = listOf(
                "₹40,000",
                "₹45,000",
                "₹50,000",
                "₹55,000"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0025",
            question = "Profit and Loss Appropriation Account is prepared to show:",
            options = listOf(
                "Trading profit only",
                "Distribution of profit among partners",
                "Cash transactions",
                "Purchase of fixed assets"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0026",
            question = "When interest on drawings is charged, the partner's capital/current account is generally:",
            options = listOf(
                "Credited",
                "Debited",
                "Closed",
                "Not affected"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0027",
            question = "A and B share profits 5:3. A is guaranteed ₹30,000. The firm earns ₹56,000. A's normal share is ₹35,000. Which statement is correct?",
            options = listOf(
                "A receives ₹30,000",
                "A receives ₹35,000 and no deficiency arises",
                "B compensates A ₹5,000",
                "Firm bears ₹5,000 deficiency"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0028",
            question = "If the partnership deed is silent about salary to partners, partner's salary is:",
            options = listOf(
                "₹5,000 p.m.",
                "₹10,000 p.m.",
                "Not allowed",
                "Allowed at market rate"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0029",
            question = "A partner is entitled to remuneration of ₹8,000 per month according to the deed. Annual remuneration will be:",
            options = listOf(
                "₹80,000",
                "₹88,000",
                "₹96,000",
                "₹1,08,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_1_m0030",
            question = "A partner's drawings are ₹6,000 at the beginning of every month. If interest on drawings is 12% p.a., the annual interest on drawings is:",
            options = listOf(
                "₹3,960",
                "₹4,320",
                "₹4,680",
                "₹5,040"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0031",
            question = "Goodwill is classified as:",
            options = listOf(
                "Tangible asset",
                "Intangible asset",
                "Current liability",
                "Fictitious asset"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0032",
            question = "A and B share profits in the ratio 3:2. C is admitted for 1/5 share, acquired equally from A and B. The new ratio will be:",
            options = listOf(
                "5:3:2",
                "2:1:2",
                "2:1:1",
                "3:2:1"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0033",
            question = "A and B share profits 3:2. C is admitted for 1/5 share, acquired equally from A and B. Goodwill of the firm is ₹1,50,000. The amount of goodwill attributable to A's sacrifice is:",
            options = listOf(
                "₹10,000",
                "₹15,000",
                "₹20,000",
                "₹25,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0034",
            question = "Goodwill mainly represents the:",
            options = listOf(
                "Cash balance of the firm",
                "Reputation and earning capacity of the firm",
                "Total liabilities of the firm",
                "Physical assets of the firm"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0035",
            question = "A and B share profits 3:2. C is admitted for 1/5 share, which he acquires entirely from A. The new ratio is:",
            options = listOf(
                "2:2:1",
                "1:2:2",
                "3:1:1",
                "2:3:1"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0036",
            question = "Average profit is ₹1,20,000. Capital employed is ₹8,00,000 and normal rate of return is 10%. Goodwill is valued at 3 years' purchase of super profit. Goodwill is:",
            options = listOf(
                "₹60,000",
                "₹96,000",
                "₹1,20,000",
                "₹1,44,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0037",
            question = "A new partner is admitted into a firm mainly with the consent of:",
            options = listOf(
                "New partner only",
                "Any one existing partner",
                "All existing partners",
                "Creditors"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0038",
            question = "Average profit of a firm is ₹60,000 and goodwill is valued at three years' purchase. Goodwill is:",
            options = listOf(
                "₹1,20,000",
                "₹1,50,000",
                "₹1,80,000",
                "₹2,40,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0039",
            question = "A and B share profits 5:3. C is admitted for 1/4 share, acquired from A and B in the ratio 2:1. The new ratio of A:B:C is:",
            options = listOf(
                "11:7:6",
                "13:8:6",
                "13:7:4",
                "10:6:4"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0040",
            question = "The new partner brings goodwill primarily to compensate the:",
            options = listOf(
                "Gaining partners",
                "Sacrificing partners",
                "Creditors",
                "Employees"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0041",
            question = "Average profit is ₹80,000. Capital employed is ₹5,00,000 and normal rate of return is 10%. Super profit is:",
            options = listOf(
                "₹20,000",
                "₹30,000",
                "₹40,000",
                "₹50,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0042",
            question = "A and B share profits 3:2. C is admitted for 1/5 share. C brings ₹50,000 as capital and ₹20,000 as goodwill premium. The implied total capital of the firm after admission, based on C's capital, is:",
            options = listOf(
                "₹1,50,000",
                "₹2,00,000",
                "₹2,50,000",
                "₹3,00,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0043",
            question = "Sacrificing ratio is calculated as:",
            options = listOf(
                "New ratio − Old ratio",
                "Old ratio − New ratio",
                "Old ratio + New ratio",
                "New ratio ÷ Old ratio"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0044",
            question = "Super profit is ₹30,000 and years' purchase is 4. Goodwill under the Super Profit Method is:",
            options = listOf(
                "₹60,000",
                "₹90,000",
                "₹1,20,000",
                "₹1,50,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0045",
            question = "Average profit of a firm is ₹90,000. Capital employed is ₹6,00,000 and normal rate of return is 12%. Goodwill is valued at 4 years' purchase of super profit. Goodwill equals:",
            options = listOf(
                "₹48,000",
                "₹60,000",
                "₹72,000",
                "₹96,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0046",
            question = "If goodwill is valued at ₹50,000 and a new partner gets 1/5 share, his share of goodwill is:",
            options = listOf(
                "₹5,000",
                "₹10,000",
                "₹15,000",
                "₹20,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0047",
            question = "A firm has capital employed of ₹6,00,000. Normal rate of return is 10%. Its normal profit is:",
            options = listOf(
                "₹6,000",
                "₹60,000",
                "₹66,000",
                "₹70,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0048",
            question = "A and B share profits 3:2. C is admitted for 1/4 share, which he acquires 3/20 from A and 1/20 from B. The new ratio is:",
            options = listOf(
                "9:9:7",
                "9:7:4",
                "3:2:1",
                "12:8:5"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0049",
            question = "Under the Average Profit Method, goodwill is calculated using:",
            options = listOf(
                "Average profit and years' purchase",
                "Capital and interest rate only",
                "Assets and liabilities only",
                "Sales and purchases only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0050",
            question = "A and B share profits 5:3. C is admitted for 1/4 share, acquired equally from A and B. A's sacrifice is:",
            options = listOf(
                "1/8",
                "1/10",
                "1/12",
                "1/16"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0051",
            question = "A firm's average profit is ₹1,50,000. Normal rate of return is 10% and capitalised value of the business based on average profit is ₹12,00,000. The capital employed is:",
            options = listOf(
                "₹10,00,000",
                "₹12,00,000",
                "₹15,00,000",
                "₹18,00,000"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0052",
            question = "Super Profit is calculated as:",
            options = listOf(
                "Normal Profit − Actual Profit",
                "Actual Profit − Normal Profit",
                "Capital − Profit",
                "Sales − Expenses"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0053",
            question = "If the new partner does not bring goodwill in cash but goodwill is to be adjusted through capital accounts, the adjustment is made in favour of:",
            options = listOf(
                "Gaining partners",
                "Sacrificing partners",
                "New partner",
                "Creditors"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0054",
            question = "Average profit is ₹1,20,000 and normal rate of return is 10%. Capital employed is ₹10,00,000. If goodwill is valued at 3 years' purchase of super profit, goodwill is:",
            options = listOf(
                "₹30,000",
                "₹60,000",
                "₹90,000",
                "₹1,20,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0055",
            question = "Normal Profit is calculated by applying the normal rate of return on:",
            options = listOf(
                "Drawings",
                "Capital employed",
                "Sales",
                "Goodwill"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0056",
            question = "A firm's average profit is ₹1,00,000 and normal profit is ₹70,000. Super profit equals:",
            options = listOf(
                "₹20,000",
                "₹30,000",
                "₹40,000",
                "₹70,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0057",
            question = "A and B share profits 4:3. C is admitted for 1/7 share, acquired from A and B in their old ratio. The new ratio will be:",
            options = listOf(
                "3:3:1",
                "4:3:1",
                "3:2:1",
                "2:2:1"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0058",
            question = "When a new partner brings goodwill in cash, the amount is credited to the:",
            options = listOf(
                "Gaining partners' capital accounts",
                "Sacrificing partners' capital accounts",
                "New partner's drawings account",
                "Cash account"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0059",
            question = "If goodwill is valued at ₹2,40,000 and the incoming partner acquires 1/6 share, the premium for goodwill is:",
            options = listOf(
                "₹20,000",
                "₹30,000",
                "₹40,000",
                "₹60,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_2_m0060",
            question = "A and B share profits 3:2. C is admitted for 1/5 share. After admission, A's share becomes 1/2. The share sacrificed by B is:",
            options = listOf(
                "1/20",
                "1/10",
                "3/20",
                "1/5"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0061",
            question = "On retirement of a partner, the retiring partner is entitled to:",
            options = listOf(
                "His share of goodwill",
                "His share of reserves",
                "His share of revaluation profit/loss",
                "All of these"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0062",
            question = "A, B and C share profits in the ratio 3:2:1. C retires and A and B decide to share future profits equally. A's gain is:",
            options = listOf(
                "1/6",
                "1/12",
                "1/3",
                "1/4"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0063",
            question = "A, B and C share profits 5:3:2. C retires. A and B decide to share future profits in the ratio 3:2. The gaining ratio of A and B is:",
            options = listOf(
                "1:1",
                "1:2",
                "2:1",
                "3:2"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0064",
            question = "The ratio in which the remaining partners acquire the retiring partner's share is called:",
            options = listOf(
                "Sacrificing ratio",
                "Gaining ratio",
                "Capital ratio",
                "Current ratio"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0065",
            question = "A, B and C share profits 5:3:2. C retires. A and B continue in the ratio 3:2. The gaining ratio of A and B is:",
            options = listOf(
                "1:1",
                "2:3",
                "3:2",
                "5:3"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0066",
            question = "A, B and C share profits 3:2:1. C retires. A acquires 1/12 of C's share and B acquires the remaining share. The gaining ratio of A and B is:",
            options = listOf(
                "1:1",
                "1:2",
                "1:3",
                "2:1"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0067",
            question = "Gaining ratio is calculated as:",
            options = listOf(
                "Old ratio − New ratio",
                "New ratio − Old ratio",
                "Old ratio + New ratio",
                "Capital ratio − New ratio"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0068",
            question = "A retiring partner's capital account has a credit balance of ₹80,000. His share of goodwill is ₹20,000 and share of revaluation profit is ₹5,000. Amount due before any other adjustment is:",
            options = listOf(
                "₹85,000",
                "₹95,000",
                "₹1,00,000",
                "₹1,05,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0069",
            question = "A, B and C share profits 4:3:2. C retires. Goodwill of the firm is ₹90,000. A and B acquire C's share in the ratio 2:1. The amount of goodwill borne by A is:",
            options = listOf(
                "₹10,000",
                "₹15,000",
                "₹20,000",
                "₹30,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0070",
            question = "On retirement, goodwill adjustment is made in favour of the:",
            options = listOf(
                "Gaining partners",
                "Sacrificing partners",
                "Retiring partner",
                "Creditors"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0071",
            question = "A, B and C share profits 4:3:2. C retires. A and B acquire C's share in the ratio 2:1. Their gaining ratio is:",
            options = listOf(
                "2:1",
                "4:3",
                "3:2",
                "1:1"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0072",
            question = "A, B and C share profits 3:2:1. C retires. Goodwill is ₹1,20,000. A and B decide to share future profits equally. The amount of goodwill adjustment between A and B will be:",
            options = listOf(
                "₹5,000",
                "₹10,000",
                "₹20,000",
                "₹30,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0073",
            question = "Profit or loss on revaluation at the time of retirement is transferred to:",
            options = listOf(
                "Remaining partners only",
                "Retiring partner only",
                "All partners in their old profit-sharing ratio",
                "New partners only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0074",
            question = "A partner's share of goodwill is ₹30,000. The retiring partner is paid this amount by the gaining partners. The entry involves:",
            options = listOf(
                "Debit gaining partners, credit retiring partner",
                "Debit retiring partner, credit gaining partners",
                "Debit goodwill, credit cash only",
                "Debit cash, credit gaining partners"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0075",
            question = "A, B and C share profits 5:3:2. B retires. A and C agree to share future profits 3:2. The gaining ratio of A and C is:",
            options = listOf(
                "1:1",
                "2:1",
                "3:2",
                "5:2"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0076",
            question = "On retirement, accumulated profits are transferred to partners' capital/current accounts in their:",
            options = listOf(
                "New ratio",
                "Gaining ratio",
                "Old profit-sharing ratio",
                "Capital ratio"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0077",
            question = "At retirement, an increase in the value of an asset is recorded by:",
            options = listOf(
                "Debiting Revaluation A/c",
                "Crediting Revaluation A/c",
                "Debiting Capital A/c",
                "Crediting Drawings A/c"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0078",
            question = "A, B and C share profits 2:3:5. B retires. A and C decide to share future profits in the ratio 1:2. The gaining ratio of A and C is:",
            options = listOf(
                "1:1",
                "1:2",
                "2:1",
                "3:2"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0079",
            question = "On the death of a partner, the amount due to the deceased partner is transferred to:",
            options = listOf(
                "His drawings account",
                "His executor's account",
                "Revaluation account",
                "Goodwill account"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0080",
            question = "At retirement, a decrease in the value of an asset is:",
            options = listOf(
                "Credited to Revaluation A/c",
                "Debited to Revaluation A/c",
                "Credited to Capital A/c directly",
                "Ignored"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0081",
            question = "A, B and C share profits 3:2:1. C dies on 30 June. The firm's profit for the previous year was ₹1,20,000. If profit is assumed to accrue evenly, C's share of profit up to death is:",
            options = listOf(
                "₹5,000",
                "₹10,000",
                "₹15,000",
                "₹20,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0082",
            question = "The deceased partner's share of profit up to the date of death is calculated because:",
            options = listOf(
                "It is his entitlement",
                "It is a liability to creditors",
                "It is a business expense",
                "It is transferred to goodwill"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0083",
            question = "A, B and C share profits equally. C retires. A and B continue equally. C's share is acquired by A and B:",
            options = listOf(
                "In the ratio 2:1",
                "In the ratio 1:2",
                "Equally",
                "In capital ratio"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0084",
            question = "A, B and C share profits 4:3:2. B dies after 3 months. Previous year's profit was ₹1,80,000. Assuming profit accrues evenly, B's share of profit up to death is:",
            options = listOf(
                "₹10,000",
                "₹15,000",
                "₹20,000",
                "₹30,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0085",
            question = "The amount due to a retiring partner may be paid:",
            options = listOf(
                "Immediately",
                "In instalments",
                "Transferred to his loan account",
                "Any of these, according to agreement"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0086",
            question = "If the retiring partner's dues are not paid immediately and transferred to his loan account, the loan account represents:",
            options = listOf(
                "An asset of the firm",
                "A liability of the firm",
                "An expense",
                "A reserve"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0087",
            question = "A, B and C share profits 3:2:1. C retires. Revaluation results in a profit of ₹30,000 and accumulated reserve is ₹12,000. C's total share from these two items is:",
            options = listOf(
                "₹5,000",
                "₹7,000",
                "₹8,000",
                "₹10,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0088",
            question = "If a partner dies during the year, his share of profit up to the date of death is credited to his:",
            options = listOf(
                "Capital account",
                "Drawings account",
                "Loan account only",
                "Revaluation account"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0089",
            question = "On death of a partner, his share of goodwill is credited to his capital account and debited to:",
            options = listOf(
                "All remaining partners equally",
                "Gaining partners in gaining ratio",
                "Sacrificing partners in sacrificing ratio",
                "Creditors"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_3_m0090",
            question = "A, B and C share profits 3:2:1. C dies. His capital is ₹70,000, share of goodwill is ₹20,000, share of reserve is ₹5,000 and profit up to death is ₹10,000. Ignoring other adjustments, amount due to C's executor is:",
            options = listOf(
                "₹85,000",
                "₹95,000",
                "₹1,00,000",
                "₹1,05,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0091",
            question = "Dissolution of a firm means:",
            options = listOf(
                "Change in profit-sharing ratio",
                "Admission of a partner",
                "Closure of the firm's business and settlement of accounts",
                "Retirement of a partner"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0092",
            question = "Machinery having a book value of ₹80,000 is sold for ₹70,000. The effect on Realisation Account is:",
            options = listOf(
                "Profit ₹10,000",
                "Loss ₹10,000",
                "Profit ₹70,000",
                "No effect"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0093",
            question = "A and B share profits equally. Assets transferred to Realisation Account are ₹1,20,000 and external liabilities transferred are ₹50,000. Assets realise ₹1,00,000 and liabilities are settled for ₹45,000. Realisation expenses are ₹5,000. Realisation profit/loss is:",
            options = listOf(
                "Profit ₹20,000",
                "Profit ₹10,000",
                "Loss ₹10,000",
                "Loss ₹20,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0094",
            question = "On dissolution, which account is prepared to record the sale of assets and settlement of liabilities?",
            options = listOf(
                "Capital Account",
                "Revaluation Account",
                "Realisation Account",
                "Trading Account"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0095",
            question = "Debtors of ₹60,000 are realised at ₹54,000. The loss on realisation is:",
            options = listOf(
                "₹4,000",
                "₹5,000",
                "₹6,000",
                "₹10,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0096",
            question = "An asset with book value ₹50,000 is taken over by Partner A at ₹45,000. The Realisation Account will show:",
            options = listOf(
                "Debit ₹50,000 and credit ₹45,000",
                "Debit ₹45,000 and credit ₹50,000",
                "Only credit ₹45,000",
                "No entry"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0097",
            question = "On dissolution, assets are generally transferred to:",
            options = listOf(
                "Cash Account",
                "Realisation Account",
                "Capital Account",
                "Bank Account"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0098",
            question = "Creditors of ₹50,000 are settled for ₹47,000. The resulting gain is:",
            options = listOf(
                "₹2,000",
                "₹3,000",
                "₹5,000",
                "₹47,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0099",
            question = "A creditor of ₹40,000 takes over machinery valued at ₹35,000 in full settlement of his claim. The balance ₹5,000 is:",
            options = listOf(
                "Paid by the creditor",
                "Paid by the firm",
                "Transferred to partners' capital accounts",
                "Ignored"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0100",
            question = "External liabilities are transferred to Realisation Account at:",
            options = listOf(
                "Book value",
                "Market value",
                "Realisable value",
                "Nil value"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0101",
            question = "If a partner takes over an asset at ₹40,000, the partner's capital account is:",
            options = listOf(
                "Debited ₹40,000",
                "Credited ₹40,000",
                "Debited ₹20,000",
                "Not affected"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0102",
            question = "An unrecorded asset is sold for ₹12,000 and an unrecorded liability of ₹7,000 is paid. The net effect on Realisation Account is:",
            options = listOf(
                "Profit ₹5,000",
                "Loss ₹5,000",
                "Profit ₹19,000",
                "Loss ₹19,000"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0103",
            question = "An unrecorded asset realised for cash on dissolution is credited to:",
            options = listOf(
                "Partner's Capital Account",
                "Cash/Bank Account",
                "Realisation Account",
                "Goodwill Account"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0104",
            question = "If a partner takes over a liability of ₹15,000, his capital account is:",
            options = listOf(
                "Debited ₹15,000",
                "Credited ₹15,000",
                "Credited ₹30,000",
                "Not affected"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0105",
            question = "Realisation Account shows total credits of ₹1,50,000 and total debits of ₹1,65,000 before transfer to partners. The result is:",
            options = listOf(
                "Realisation profit ₹15,000",
                "Realisation loss ₹15,000",
                "Realisation profit ₹3,15,000",
                "No profit/loss"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0106",
            question = "An unrecorded liability paid on dissolution is debited to:",
            options = listOf(
                "Realisation Account",
                "Cash Account",
                "Capital Account",
                "Bank Loan Account"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0107",
            question = "If a firm's asset is taken over by a partner at ₹25,000, the Realisation Account is:",
            options = listOf(
                "Debited ₹25,000",
                "Credited ₹25,000",
                "Not affected",
                "Debited ₹50,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0108",
            question = "A and B share profits 3:2. On dissolution, Realisation Account shows a loss of ₹25,000. A's share of the loss is:",
            options = listOf(
                "₹10,000",
                "₹12,000",
                "₹15,000",
                "₹20,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0109",
            question = "Realisation profit or loss is transferred to partners' capital accounts in their:",
            options = listOf(
                "New ratio",
                "Gaining ratio",
                "Old profit-sharing ratio",
                "Capital ratio"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_4_m0110",
            question = "If realisation expenses of ₹8,000 are paid by the firm, the entry includes:",
            options = listOf(
                "Realisation A/c Dr. ₹8,000",
                "Cash A/c Dr. ₹8,000",
                "Capital A/c Dr. ₹8,000",
                "Realisation A/c Cr. ₹8,000"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0111",
            question = "Share capital represents:",
            options = listOf(
                "Loan taken by the company",
                "Capital raised by issuing shares",
                "Profit earned by the company",
                "Trade payable"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0112",
            question = "A company issues a ₹10 share at ₹12. The securities premium per share is:",
            options = listOf(
                "₹1",
                "₹2",
                "₹10",
                "₹12"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0113",
            question = "A company issues 20,000 shares of ₹10 each at ₹12. The shares are payable ₹3 on application, ₹5 on allotment including premium, and balance on first and final call. Securities premium included in allotment is:",
            options = listOf(
                "₹20,000",
                "₹30,000",
                "₹40,000",
                "₹60,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0114",
            question = "A company can issue shares:",
            options = listOf(
                "Only for cash",
                "Only at par",
                "At par, premium or discount subject to applicable law",
                "Only at premium"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0115",
            question = "A company issues 10,000 shares of ₹10 each at par. Total share capital raised is:",
            options = listOf(
                "₹10,000",
                "₹50,000",
                "₹1,00,000",
                "₹1,20,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0116",
            question = "A shareholder holds 2,000 shares of ₹10 each. ₹7 per share has been called and he has paid ₹5 per share. The amount of calls in arrears is:",
            options = listOf(
                "₹2,000",
                "₹3,000",
                "₹4,000",
                "₹5,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0117",
            question = "The nominal value of a share is also called its:",
            options = listOf(
                "Market value",
                "Face value",
                "Book value",
                "Realisable value"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0118",
            question = "A company issues 5,000 shares of ₹10 each at ₹14. The total securities premium is:",
            options = listOf(
                "₹10,000",
                "₹20,000",
                "₹50,000",
                "₹70,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0119",
            question = "A company forfeits 1,000 shares of ₹10 each on which ₹7 per share had been received. The amount credited to Share Forfeiture Account is:",
            options = listOf(
                "₹3,000",
                "₹5,000",
                "₹7,000",
                "₹10,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0120",
            question = "When shares are issued at a price equal to their face value, they are issued:",
            options = listOf(
                "At premium",
                "At discount",
                "At par",
                "At loss"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0121",
            question = "If ₹8 per share has been called on a ₹10 share and a shareholder has paid only ₹6, calls in arrears per share are:",
            options = listOf(
                "₹1",
                "₹2",
                "₹4",
                "₹6"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0122",
            question = "1,000 forfeited shares of ₹10 each, ₹7 called and ₹5 received, are reissued at ₹8 fully paid. The discount on reissue is:",
            options = listOf(
                "₹1,000",
                "₹2,000",
                "₹3,000",
                "₹5,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0123",
            question = "The excess of issue price over face value is called:",
            options = listOf(
                "Capital reserve",
                "Securities premium",
                "General reserve",
                "Share forfeiture"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0124",
            question = "A company receives ₹3 per share as application money on 20,000 shares. Application money received is:",
            options = listOf(
                "₹30,000",
                "₹40,000",
                "₹60,000",
                "₹80,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0125",
            question = "In Q24, the amount transferred to Capital Reserve after reissue, ignoring other costs, is:",
            options = listOf(
                "₹1,000",
                "₹2,000",
                "₹3,000",
                "₹5,000"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0126",
            question = "Application money is received when an investor:",
            options = listOf(
                "Applies for shares",
                "Receives dividend",
                "Transfers shares",
                "Forfeits shares"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0127",
            question = "If shares of ₹10 are issued at ₹13, the amount credited to Securities Premium Account per share is:",
            options = listOf(
                "₹3",
                "₹10",
                "₹13",
                "₹23"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0128",
            question = "A company issues 10,000 shares of ₹10 each at ₹12. Application ₹3, allotment ₹5 including premium and balance on final call. If one shareholder holding 500 shares fails to pay the final call of ₹4 per share, calls in arrears will be:",
            options = listOf(
                "₹1,000",
                "₹1,500",
                "₹2,000",
                "₹2,500"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0129",
            question = "Calls in arrears represent:",
            options = listOf(
                "Amount received in advance",
                "Amount not received from shareholders when due",
                "Profit on shares",
                "Securities premium"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0130",
            question = "On forfeiture of a share, the amount already received from the shareholder is generally credited to:",
            options = listOf(
                "Share Forfeiture Account",
                "Securities Premium Account",
                "Calls in Arrears Account",
                "Capital Reserve directly"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0131",
            question = "A company receives ₹5 per share in advance on 2,000 shares for a call that has not yet been made. The amount is treated as:",
            options = listOf(
                "Share capital immediately",
                "Calls in advance",
                "Securities premium",
                "Share forfeiture"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0132",
            question = "Calls in advance represent:",
            options = listOf(
                "Amount received before it is called",
                "Unpaid share capital",
                "Forfeited shares",
                "Share premium"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0133",
            question = "When forfeited shares are reissued at a discount, the discount allowed cannot generally exceed:",
            options = listOf(
                "Face value",
                "Amount originally received on those shares",
                "Amount forfeited on those shares",
                "Securities premium"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0134",
            question = "A company forfeits 500 shares of ₹10 each. ₹8 per share had been called and ₹6 per share had been received. If these shares are reissued at ₹9 fully paid, the maximum amount that can be transferred to Capital Reserve from these shares is:",
            options = listOf(
                "₹500",
                "₹1,000",
                "₹1,500",
                "₹3,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0135",
            question = "Forfeiture of shares generally occurs when a shareholder fails to pay:",
            options = listOf(
                "Dividend",
                "Amount due on shares",
                "Interest on capital",
                "Tax"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0136",
            question = "A shareholder holding 1,000 shares fails to pay ₹2 per share on a call. Calls in arrears are:",
            options = listOf(
                "₹500",
                "₹1,000",
                "₹2,000",
                "₹10,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0137",
            question = "A company issues 15,000 shares of ₹10 each at ₹2 premium. If application money is ₹4 per share, the total application money received is:",
            options = listOf(
                "₹45,000",
                "₹60,000",
                "₹90,000",
                "₹1,80,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0138",
            question = "Shares forfeited may be reissued by the company:",
            options = listOf(
                "Never",
                "Subject to applicable rules",
                "Only at face value",
                "Only to the original shareholder"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0139",
            question = "If a company receives ₹4 per share as application money on 15,000 shares, the amount received is:",
            options = listOf(
                "₹45,000",
                "₹60,000",
                "₹75,000",
                "₹1,50,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_5_m0140",
            question = "A company forfeits 2,000 shares of ₹10 each. ₹8 per share was called and ₹6 per share was received. If the shares are reissued at ₹9 fully paid, the balance remaining in Share Forfeiture Account after reissue is:",
            options = listOf(
                "₹2,000",
                "₹4,000",
                "₹6,000",
                "₹12,000"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0141",
            question = "A debenture represents:",
            options = listOf(
                "Ownership capital",
                "Borrowed capital of a company",
                "Reserve capital",
                "Share premium"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0142",
            question = "A company issues 1,000 debentures of ₹100 each at par. Amount raised is:",
            options = listOf(
                "₹10,000",
                "₹50,000",
                "₹1,00,000",
                "₹1,10,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0143",
            question = "A company issues 2,000 ₹100 debentures at 5% premium. The total amount received is:",
            options = listOf(
                "₹1,90,000",
                "₹2,00,000",
                "₹2,10,000",
                "₹2,20,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0144",
            question = "A debenture holder is a:",
            options = listOf(
                "Owner of the company",
                "Creditor of the company",
                "Promoter of the company",
                "Director of the company"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0145",
            question = "A ₹1,000 debenture is issued at 5% premium. Issue price is:",
            options = listOf(
                "₹950",
                "₹1,000",
                "₹1,050",
                "₹1,500"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0146",
            question = "₹3,00,000 debentures are issued at 4% discount and redeemable at 6% premium. Total loss on issue of debentures is:",
            options = listOf(
                "₹12,000",
                "₹18,000",
                "₹30,000",
                "₹6,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0147",
            question = "Interest on debentures is generally:",
            options = listOf(
                "Appropriation of profit",
                "Charge against profit",
                "Distribution of reserve",
                "Capital expenditure"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0148",
            question = "A company issues ₹2,00,000 of 10% debentures. Annual interest is:",
            options = listOf(
                "₹10,000",
                "₹15,000",
                "₹20,000",
                "₹25,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0149",
            question = "A company issues ₹5,00,000 10% debentures at 3% premium. Annual interest and amount of premium received are respectively:",
            options = listOf(
                "₹50,000 and ₹15,000",
                "₹15,000 and ₹50,000",
                "₹50,000 and ₹5,000",
                "₹35,000 and ₹15,000"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0150",
            question = "Debentures may be issued:",
            options = listOf(
                "At par only",
                "At premium only",
                "At discount only",
                "At par, premium or discount, subject to applicable law"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0151",
            question = "₹5,00,000, 8% debentures are issued. Annual debenture interest is:",
            options = listOf(
                "₹20,000",
                "₹30,000",
                "₹40,000",
                "₹50,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0152",
            question = "A company issues ₹4,00,000 debentures at 5% discount, redeemable at 10% premium. The total loss on issue is:",
            options = listOf(
                "₹20,000",
                "₹40,000",
                "₹60,000",
                "₹80,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0153",
            question = "The amount above the face value of a debenture is called:",
            options = listOf(
                "Capital reserve",
                "Securities premium",
                "General reserve",
                "Debenture reserve"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0154",
            question = "If ₹1,00,000 debentures are issued at 4% discount, cash received is:",
            options = listOf(
                "₹96,000",
                "₹1,04,000",
                "₹1,00,000",
                "₹90,000"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0155",
            question = "₹2,00,000 12% debentures are issued at 5% premium and redeemable at 10% premium. The total amount payable on redemption is:",
            options = listOf(
                "₹2,00,000",
                "₹2,10,000",
                "₹2,20,000",
                "₹2,30,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0156",
            question = "Debentures issued as security for a loan are called:",
            options = listOf(
                "Convertible debentures",
                "Collateral security",
                "Redeemable shares",
                "Bonus debentures"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0157",
            question = "If ₹2,00,000 debentures are redeemable at 5% premium, the amount payable on redemption is:",
            options = listOf(
                "₹1,90,000",
                "₹2,00,000",
                "₹2,05,000",
                "₹2,10,000"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0158",
            question = "A company issues ₹6,00,000 debentures at 4% discount. If the debentures are redeemable at par, the amount of loss on issue is:",
            options = listOf(
                "₹12,000",
                "₹24,000",
                "₹30,000",
                "₹36,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0159",
            question = "Debenture interest is calculated on:",
            options = listOf(
                "Market value",
                "Face value of debentures",
                "Book value of assets",
                "Net profit"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0160",
            question = "When debentures are issued at discount and redeemable at premium, the company incurs:",
            options = listOf(
                "Only discount",
                "Only premium",
                "Both discount and premium",
                "Neither"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0161",
            question = "A company issues ₹3,00,000 8% debentures at 6% premium. If interest is paid half-yearly, each instalment of interest will be:",
            options = listOf(
                "₹12,000",
                "₹18,000",
                "₹24,000",
                "₹9,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0162",
            question = "Redemption of debentures means:",
            options = listOf(
                "Issue of shares",
                "Repayment of debenture liability",
                "Payment of dividend",
                "Creation of goodwill"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0163",
            question = "If debenture interest is payable half-yearly, the interest on ₹4,00,000 12% debentures for one half-year is:",
            options = listOf(
                "₹12,000",
                "₹24,000",
                "₹48,000",
                "₹6,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_6_m0164",
            question = "₹5,00,000 debentures are issued at 4% discount and redeemable at 8% premium. The total amount received on issue and amount payable on redemption are respectively:",
            options = listOf(
                "₹4,80,000 and ₹5,40,000",
                "₹5,20,000 and ₹5,40,000",
                "₹4,80,000 and ₹5,00,000",
                "₹5,00,000 and ₹5,40,000"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0165",
            question = "Financial statements are prepared mainly to:",
            options = listOf(
                "Record daily transactions",
                "Show the financial performance and position of a company",
                "Calculate only cash balance",
                "Determine partners' profit"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0166",
            question = "Which of the following is a non-current asset?",
            options = listOf(
                "Inventory",
                "Trade receivables",
                "Plant and machinery",
                "Cash"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0167",
            question = "A company has current assets of ₹4,00,000 and current liabilities of ₹2,50,000. Its working capital is:",
            options = listOf(
                "₹1,00,000",
                "₹1,50,000",
                "₹2,50,000",
                "₹6,50,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0168",
            question = "The Balance Sheet shows the:",
            options = listOf(
                "Financial position of the company",
                "Daily sales",
                "Cash receipts only",
                "Gross profit only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0169",
            question = "Which of the following is generally a current liability?",
            options = listOf(
                "Equity share capital",
                "Trade payables",
                "Goodwill",
                "Land"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0170",
            question = "Revenue from operations is ₹8,00,000, cost of goods sold is ₹5,00,000 and operating expenses are ₹1,20,000. Operating profit before other adjustments is:",
            options = listOf(
                "₹1,20,000",
                "₹1,80,000",
                "₹2,00,000",
                "₹3,00,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0171",
            question = "The Statement of Profit and Loss shows:",
            options = listOf(
                "Assets only",
                "Liabilities only",
                "Income and expenses of the company",
                "Shareholders' names"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0172",
            question = "Revenue from operations for a manufacturing company mainly includes:",
            options = listOf(
                "Sale of goods",
                "Issue of shares",
                "Bank loan",
                "Sale of investments only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0173",
            question = "A company has trade receivables ₹2,00,000 and provision for doubtful debts ₹10,000. The net amount of trade receivables shown will be:",
            options = listOf(
                "₹2,10,000",
                "₹2,00,000",
                "₹1,90,000",
                "₹10,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0174",
            question = "Assets are generally shown on the:",
            options = listOf(
                "Liabilities side only",
                "Assets side of the Balance Sheet",
                "Profit and Loss Statement only",
                "Cash Book"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0175",
            question = "Depreciation is treated as:",
            options = listOf(
                "Income",
                "Expense",
                "Liability",
                "Capital receipt"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0176",
            question = "Current assets are ₹6,00,000 and current liabilities are ₹3,00,000. If ₹50,000 of trade payables are paid, the new current ratio will be:",
            options = listOf(
                "1.5:1",
                "2:1",
                "2.2:1",
                "2.5:1"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0177",
            question = "Trade receivables represent:",
            options = listOf(
                "Amount payable to suppliers",
                "Amount receivable from customers",
                "Bank loan",
                "Share capital"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0178",
            question = "Outstanding expenses are:",
            options = listOf(
                "Assets",
                "Liabilities",
                "Income",
                "Drawings"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0179",
            question = "A company purchases machinery for ₹5,00,000 and pays ₹50,000 for installation. The amount initially recognised as machinery will be:",
            options = listOf(
                "₹4,50,000",
                "₹5,00,000",
                "₹5,50,000",
                "₹50,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0180",
            question = "Trade payables are:",
            options = listOf(
                "Amount due to suppliers",
                "Amount due from customers",
                "Cash in hand",
                "Investments"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0181",
            question = "Prepaid expenses are classified as:",
            options = listOf(
                "Current assets",
                "Current liabilities",
                "Equity",
                "Revenue"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0182",
            question = "A company has profit before tax of ₹2,50,000 and tax expense of ₹70,000. Profit after tax is:",
            options = listOf(
                "₹1,80,000",
                "₹2,00,000",
                "₹3,20,000",
                "₹70,000"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0183",
            question = "Share capital is shown under:",
            options = listOf(
                "Current assets",
                "Shareholders' funds/equity",
                "Current liabilities",
                "Revenue from operations"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0184",
            question = "A provision for doubtful debts is created mainly to:",
            options = listOf(
                "Increase sales",
                "Recognise possible loss from doubtful receivables",
                "Increase share capital",
                "Reduce liabilities"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0185",
            question = "If current assets increase by ₹40,000 while current liabilities remain unchanged at ₹2,00,000, and existing current assets were ₹4,00,000, the current ratio becomes:",
            options = listOf(
                "2:1",
                "2.1:1",
                "2.2:1",
                "2.4:1"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0186",
            question = "Inventories are classified as:",
            options = listOf(
                "Current assets",
                "Non-current liabilities",
                "Shareholders' funds",
                "Revenue"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0187",
            question = "Which item is normally shown under Other Current Assets?",
            options = listOf(
                "Short-term loans and advances",
                "Equity share capital",
                "Long-term borrowings",
                "Debentures"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_7_m0188",
            question = "A company's total assets are ₹15,00,000 and total liabilities excluding shareholders' funds are ₹6,00,000. Shareholders' funds will be:",
            options = listOf(
                "₹6,00,000",
                "₹9,00,000",
                "₹15,00,000",
                "₹21,00,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0189",
            question = "Accounting ratios are mainly used to:",
            options = listOf(
                "Record journal entries",
                "Analyse financial performance and position",
                "Prepare cash book",
                "Calculate share capital only"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0190",
            question = "Current assets are ₹3,00,000 and current liabilities are ₹1,50,000. Current Ratio is:",
            options = listOf(
                "1:1",
                "1.5:1",
                "2:1",
                "3:1"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0191",
            question = "A company's current ratio is 2:1. Current liabilities are ₹2,00,000. Current assets are:",
            options = listOf(
                "₹1,00,000",
                "₹2,00,000",
                "₹4,00,000",
                "₹6,00,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0192",
            question = "Current Ratio is calculated as:",
            options = listOf(
                "Current Assets ÷ Current Liabilities",
                "Current Liabilities ÷ Current Assets",
                "Liquid Assets ÷ Current Liabilities",
                "Sales ÷ Current Assets"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0193",
            question = "Quick assets are ₹1,80,000 and current liabilities are ₹1,20,000. Quick Ratio is:",
            options = listOf(
                "1:1",
                "1.5:1",
                "2:1",
                "2.5:1"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0194",
            question = "Current assets are ₹5,00,000, including inventory ₹1,50,000 and prepaid expenses ₹50,000. Current liabilities are ₹2,00,000. Quick Ratio is:",
            options = listOf(
                "1:1",
                "1.25:1",
                "1.5:1",
                "2.5:1"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0195",
            question = "Quick Ratio is also known as:",
            options = listOf(
                "Current Ratio",
                "Acid-Test Ratio",
                "Debt Ratio",
                "Gross Profit Ratio"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0196",
            question = "Revenue from Operations is ₹8,00,000 and Gross Profit is ₹2,00,000. Gross Profit Ratio is:",
            options = listOf(
                "20%",
                "25%",
                "30%",
                "40%"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0197",
            question = "Revenue from Operations is ₹10,00,000, Gross Profit is ₹3,00,000 and operating expenses are ₹1,20,000. Operating Profit Ratio is:",
            options = listOf(
                "12%",
                "18%",
                "20%",
                "30%"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0198",
            question = "Gross Profit Ratio is calculated on:",
            options = listOf(
                "Cost of Revenue from Operations",
                "Revenue from Operations",
                "Total Assets",
                "Capital Employed"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0199",
            question = "Cost of Revenue from Operations is ₹6,00,000 and Gross Profit is ₹1,50,000. Revenue from Operations is:",
            options = listOf(
                "₹4,50,000",
                "₹6,50,000",
                "₹7,50,000",
                "₹9,00,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0200",
            question = "A company's Debt-Equity Ratio is 1.5:1 and shareholders' funds are ₹6,00,000. Long-term debt is:",
            options = listOf(
                "₹3,00,000",
                "₹6,00,000",
                "₹9,00,000",
                "₹12,00,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0201",
            question = "Debt-Equity Ratio compares:",
            options = listOf(
                "Current assets and current liabilities",
                "Debt and shareholders' funds",
                "Sales and profit",
                "Gross profit and net profit"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0202",
            question = "Shareholders' funds are ₹5,00,000 and long-term debt is ₹2,50,000. Debt-Equity Ratio is:",
            options = listOf(
                "0.5:1",
                "1:1",
                "2:1",
                "2.5:1"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0203",
            question = "Cost of Revenue from Operations is ₹6,00,000 and Inventory Turnover Ratio is 5 times. Average inventory is:",
            options = listOf(
                "₹1,00,000",
                "₹1,20,000",
                "₹1,50,000",
                "₹2,00,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0204",
            question = "Inventory Turnover Ratio measures:",
            options = listOf(
                "Liquidity of creditors",
                "Efficiency of inventory management",
                "Profitability of shareholders",
                "Long-term solvency only"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0205",
            question = "Cost of Revenue from Operations is ₹4,00,000 and average inventory is ₹1,00,000. Inventory Turnover Ratio is:",
            options = listOf(
                "2 times",
                "3 times",
                "4 times",
                "5 times"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0206",
            question = "Net Profit after Tax is ₹1,20,000. Capital employed is ₹8,00,000. Return on Capital Employed is:",
            options = listOf(
                "10%",
                "12%",
                "15%",
                "20%"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0207",
            question = "Return on Investment is generally related to:",
            options = listOf(
                "Profitability",
                "Liquidity",
                "Inventory only",
                "Trade receivables only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_8_m0208",
            question = "Net Profit after Tax is ₹80,000 and Revenue from Operations is ₹4,00,000. Net Profit Ratio is:",
            options = listOf(
                "10%",
                "15%",
                "20%",
                "25%"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0209",
            question = "Cash Flow Statement mainly shows:",
            options = listOf(
                "Profit earned during the year",
                "Changes in cash and cash equivalents",
                "Changes in share capital only",
                "Total assets of the company"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0210",
            question = "Dividend paid by a company is generally classified as:",
            options = listOf(
                "Operating activity",
                "Investing activity",
                "Financing activity",
                "Non-cash activity"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0211",
            question = "Net profit before tax is ₹2,00,000. Depreciation is ₹30,000 and gain on sale of machinery is ₹10,000. Ignoring working-capital changes, cash from operating activities before tax is:",
            options = listOf(
                "₹1,60,000",
                "₹2,20,000",
                "₹2,30,000",
                "₹2,40,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0212",
            question = "Cash flows are classified into how many main activities?",
            options = listOf(
                "Two",
                "Three",
                "Four",
                "Five"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0213",
            question = "Interest received by a non-financial company is generally classified as:",
            options = listOf(
                "Operating activity",
                "Investing activity",
                "Financing activity",
                "Cash equivalent"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0214",
            question = "Trade receivables increased by ₹20,000 and trade payables increased by ₹15,000. Ignoring other adjustments, the combined effect on cash from operating activities is:",
            options = listOf(
                "Increase ₹35,000",
                "Decrease ₹35,000",
                "Decrease ₹5,000",
                "Increase ₹5,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0215",
            question = "The three activities are:",
            options = listOf(
                "Operating, Investing and Financing",
                "Trading, Profit and Loss and Balance Sheet",
                "Current, Fixed and Intangible",
                "Capital, Revenue and Deferred"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0216",
            question = "Interest paid by a non-financial company is generally classified as:",
            options = listOf(
                "Operating activity",
                "Investing activity",
                "Financing activity",
                "Non-cash activity"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0217",
            question = "A company purchased machinery for ₹4,00,000 and sold another machine for ₹1,00,000. The net cash flow from these investing transactions is:",
            options = listOf(
                "Inflow ₹5,00,000",
                "Outflow ₹3,00,000",
                "Inflow ₹3,00,000",
                "Outflow ₹5,00,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0218",
            question = "Cash received from customers is generally classified as:",
            options = listOf(
                "Operating activity",
                "Investing activity",
                "Financing activity",
                "Non-cash activity"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0219",
            question = "Sale of machinery for cash is classified as:",
            options = listOf(
                "Operating activity",
                "Investing activity",
                "Financing activity",
                "Current liability"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0220",
            question = "A company issues shares for ₹5,00,000 and redeems debentures for ₹2,00,000. Ignoring other financing items, net cash flow from financing activities is:",
            options = listOf(
                "₹3,00,000 inflow",
                "₹7,00,000 inflow",
                "₹3,00,000 outflow",
                "₹7,00,000 outflow"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0221",
            question = "Purchase of machinery for cash is a:",
            options = listOf(
                "Operating activity",
                "Investing activity",
                "Financing activity",
                "Non-cash transaction"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0222",
            question = "Cash received from issue of debentures is:",
            options = listOf(
                "Operating inflow",
                "Investing inflow",
                "Financing inflow",
                "Non-cash inflow"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0223",
            question = "Profit before tax is ₹3,00,000. Depreciation ₹40,000, increase in inventory ₹25,000 and increase in trade payables ₹15,000. Ignoring other adjustments, cash generated from operations before tax is:",
            options = listOf(
                "₹2,50,000",
                "₹2,90,000",
                "₹3,30,000",
                "₹3,80,000"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0224",
            question = "Issue of equity shares for cash is a:",
            options = listOf(
                "Operating activity",
                "Investing activity",
                "Financing activity",
                "Non-cash activity"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0225",
            question = "Cash paid for purchase of investments is generally:",
            options = listOf(
                "Operating outflow",
                "Investing outflow",
                "Financing outflow",
                "Non-cash transaction"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0226",
            question = "A company has opening cash ₹80,000. During the year, operating activities generate ₹1,20,000, investing activities use ₹70,000 and financing activities generate ₹30,000. Closing cash balance is:",
            options = listOf(
                "₹1,20,000",
                "₹1,40,000",
                "₹1,60,000",
                "₹2,00,000"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0227",
            question = "Cash and cash equivalents generally include:",
            options = listOf(
                "Long-term investments only",
                "Cash, bank balances and highly liquid short-term investments",
                "Inventory",
                "Trade receivables"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0228",
            question = "Under the indirect method, depreciation is:",
            options = listOf(
                "Deducted from net profit",
                "Added back to net profit",
                "Treated as financing inflow",
                "Treated as investing outflow"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0229",
            question = "A machine with book value ₹60,000 is sold for ₹50,000. In the indirect method, the ₹10,000 loss on sale is:",
            options = listOf(
                "Added to net profit",
                "Deducted from net profit",
                "Shown as financing outflow",
                "Ignored completely"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0230",
            question = "Payment to suppliers for goods is generally classified as:",
            options = listOf(
                "Operating activity",
                "Investing activity",
                "Financing activity",
                "Extraordinary activity"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0231",
            question = "An increase in trade receivables, while calculating cash flow from operating activities using the indirect method, is:",
            options = listOf(
                "Added to profit",
                "Deducted from profit",
                "Ignored",
                "Treated as financing inflow"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "accountancy_class_12_9_m0232",
            question = "A company receives ₹2,00,000 as dividend from an investment and pays ₹80,000 for purchase of machinery. Under the stated non-financial-company classification, the net investing cash flow is:",
            options = listOf(
                "₹1,20,000 inflow",
                "₹1,20,000 outflow",
                "₹2,80,000 inflow",
                "₹80,000 inflow"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "accountancy",
            chapterId = "accountancy_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0233",
            question = "Which of the following best describes management?",
            options = listOf(
                "recording only transactions",
                "selling shares only",
                "preparing tax returns",
                "achieving organisational goals through effective and efficient use of resources"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0234",
            question = "Which situation is most consistent with the concept of management?",
            options = listOf(
                "preparing tax returns",
                "achieving organisational goals through effective and efficient use of resources",
                "recording only transactions",
                "selling shares only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0235",
            question = "Which of the following best describes effectiveness?",
            options = listOf(
                "doing the right work to achieve objectives",
                "using resources without regard to results",
                "avoiding targets",
                "reducing staff automatically"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0236",
            question = "Which situation is most consistent with the concept of effectiveness?",
            options = listOf(
                "avoiding targets",
                "reducing staff automatically",
                "doing the right work to achieve objectives",
                "using resources without regard to results"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0237",
            question = "Which of the following best describes efficiency?",
            options = listOf(
                "only reducing wages",
                "doing work with minimum cost and wastage",
                "achieving no result",
                "only increasing sales"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0238",
            question = "Which situation is most consistent with the concept of efficiency?",
            options = listOf(
                "achieving no result",
                "only increasing sales",
                "only reducing wages",
                "doing work with minimum cost and wastage"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0239",
            question = "Which of the following best describes management as art?",
            options = listOf(
                "is only a legal rule",
                "is identical to a natural law",
                "requires personal skill, practice and application of knowledge",
                "has no practical use"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0240",
            question = "Which situation is most consistent with the concept of management as art?",
            options = listOf(
                "requires personal skill, practice and application of knowledge",
                "has no practical use",
                "is only a legal rule",
                "is identical to a natural law"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0241",
            question = "Which of the following best describes management as science?",
            options = listOf(
                "always gives identical results",
                "depends only on guesswork",
                "has no principles",
                "has a systematic body of knowledge and principles"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0242",
            question = "Which of the following best describes coordination?",
            options = listOf(
                "integrating efforts of different people and departments",
                "eliminating departments",
                "avoiding communication",
                "replacing planning"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0243",
            question = "Which of the following best describes top management?",
            options = listOf(
                "prepares only cash book",
                "sets overall objectives and broad policies",
                "directly supervises every worker",
                "handles only recruitment"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0244",
            question = "Which of the following best describes supervisory management?",
            options = listOf(
                "issues shares",
                "audits the company",
                "directly oversees operational employees",
                "sets national economic policy"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0245",
            question = "Which of the following best describes management as profession?",
            options = listOf(
                "requires no training",
                "has no ethical dimension",
                "is limited to business owners",
                "involves specialised knowledge and a body of professional skills"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0246",
            question = "Which of the following best describes management is pervasive?",
            options = listOf(
                "management is needed at different levels and in different organisations",
                "only factories need management",
                "only top managers plan",
                "management is needed only in finance"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0247",
            question = "Which of the following best describes management is continuous?",
            options = listOf(
                "control is done only once",
                "managerial functions continue as circumstances and goals change",
                "planning ends all management",
                "one plan never changes"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0248",
            question = "Which statement about management is correct?",
            options = listOf(
                "selling shares only",
                "preparing tax returns",
                "achieving organisational goals through effective and efficient use of resources",
                "recording only transactions"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0249",
            question = "Which statement about effectiveness is correct?",
            options = listOf(
                "using resources without regard to results",
                "avoiding targets",
                "reducing staff automatically",
                "doing the right work to achieve objectives"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0250",
            question = "Which statement about efficiency is correct?",
            options = listOf(
                "doing work with minimum cost and wastage",
                "achieving no result",
                "only increasing sales",
                "only reducing wages"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0251",
            question = "Which statement about management as art is correct?",
            options = listOf(
                "is identical to a natural law",
                "requires personal skill, practice and application of knowledge",
                "has no practical use",
                "is only a legal rule"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0252",
            question = "Which statement about management as science is correct?",
            options = listOf(
                "depends only on guesswork",
                "has no principles",
                "has a systematic body of knowledge and principles",
                "always gives identical results"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0253",
            question = "Which statement about coordination is correct?",
            options = listOf(
                "eliminating departments",
                "avoiding communication",
                "replacing planning",
                "integrating efforts of different people and departments"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0254",
            question = "Which statement about top management is correct?",
            options = listOf(
                "sets overall objectives and broad policies",
                "directly supervises every worker",
                "handles only recruitment",
                "prepares only cash book"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0255",
            question = "Which statement about supervisory management is correct?",
            options = listOf(
                "audits the company",
                "directly oversees operational employees",
                "sets national economic policy",
                "issues shares"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0256",
            question = "Which statement about management as profession is correct?",
            options = listOf(
                "has no ethical dimension",
                "is limited to business owners",
                "involves specialised knowledge and a body of professional skills",
                "requires no training"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0257",
            question = "Which statement about management is pervasive is correct?",
            options = listOf(
                "only factories need management",
                "only top managers plan",
                "management is needed only in finance",
                "management is needed at different levels and in different organisations"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_1_m0258",
            question = "Which statement about management is continuous is correct?",
            options = listOf(
                "managerial functions continue as circumstances and goals change",
                "planning ends all management",
                "one plan never changes",
                "control is done only once"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0259",
            question = "Which of the following best describes division of work?",
            options = listOf(
                "all employees must do every task",
                "specialisation is prohibited",
                "work must never be divided",
                "specialisation can improve efficiency and skill"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0260",
            question = "Which of the following best describes authority and responsibility?",
            options = listOf(
                "authority should be accompanied by responsibility",
                "they are unrelated",
                "responsibility always exceeds authority",
                "authority belongs only to owners"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0261",
            question = "Which of the following best describes unity of command?",
            options = listOf(
                "no superior is required",
                "an employee should receive orders from one superior",
                "an employee should have many immediate bosses",
                "customers issue all orders"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0262",
            question = "Which of the following best describes unity of direction?",
            options = listOf(
                "one worker needs many heads",
                "plans are unnecessary",
                "activities with the same objective should have one plan and one head",
                "every activity needs different plans"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0263",
            question = "Which of the following best describes equity?",
            options = listOf(
                "all employees must get identical roles",
                "strict punishment is the main aim",
                "seniority alone decides everything",
                "employees should receive fair and kind treatment"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0264",
            question = "Which of the following best describes initiative?",
            options = listOf(
                "employees should be encouraged to think and suggest improvements",
                "employees must never suggest ideas",
                "only owners may plan",
                "initiative means avoiding responsibility"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0265",
            question = "Which of the following best describes esprit de corps?",
            options = listOf(
                "means individual competition",
                "promotes team spirit and harmony",
                "promotes secrecy",
                "eliminates communication"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0266",
            question = "Which of the following best describes scientific management?",
            options = listOf(
                "Taylor rejected standardisation",
                "Taylor developed company law",
                "Taylor focused on science of work and efficiency",
                "Taylor focused only on marketing"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0267",
            question = "Which of the following best describes time study?",
            options = listOf(
                "measures consumer income",
                "calculates goodwill",
                "sets tax rates",
                "determines the standard time required for a task"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0268",
            question = "Which of the following best describes motion study?",
            options = listOf(
                "identifies and removes unnecessary movements",
                "measures national income",
                "calculates dividend",
                "sets selling price"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0269",
            question = "Which of the following best describes functional foremanship?",
            options = listOf(
                "is a method of advertising",
                "uses specialised supervisors for different aspects of work",
                "uses no supervisors",
                "gives all authority to one worker"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0270",
            question = "Which statement about division of work is correct?",
            options = listOf(
                "specialisation is prohibited",
                "work must never be divided",
                "specialisation can improve efficiency and skill",
                "all employees must do every task"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0271",
            question = "Which statement about authority and responsibility is correct?",
            options = listOf(
                "they are unrelated",
                "responsibility always exceeds authority",
                "authority belongs only to owners",
                "authority should be accompanied by responsibility"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0272",
            question = "Which statement about unity of command is correct?",
            options = listOf(
                "an employee should receive orders from one superior",
                "an employee should have many immediate bosses",
                "customers issue all orders",
                "no superior is required"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0273",
            question = "Which statement about unity of direction is correct?",
            options = listOf(
                "plans are unnecessary",
                "activities with the same objective should have one plan and one head",
                "every activity needs different plans",
                "one worker needs many heads"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0274",
            question = "Which statement about equity is correct?",
            options = listOf(
                "strict punishment is the main aim",
                "seniority alone decides everything",
                "employees should receive fair and kind treatment",
                "all employees must get identical roles"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0275",
            question = "Which statement about initiative is correct?",
            options = listOf(
                "employees must never suggest ideas",
                "only owners may plan",
                "initiative means avoiding responsibility",
                "employees should be encouraged to think and suggest improvements"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0276",
            question = "Which statement about esprit de corps is correct?",
            options = listOf(
                "promotes team spirit and harmony",
                "promotes secrecy",
                "eliminates communication",
                "means individual competition"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0277",
            question = "Which statement about scientific management is correct?",
            options = listOf(
                "Taylor developed company law",
                "Taylor focused on science of work and efficiency",
                "Taylor focused only on marketing",
                "Taylor rejected standardisation"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0278",
            question = "Which statement about time study is correct?",
            options = listOf(
                "calculates goodwill",
                "sets tax rates",
                "determines the standard time required for a task",
                "measures consumer income"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0279",
            question = "Which statement about motion study is correct?",
            options = listOf(
                "measures national income",
                "calculates dividend",
                "sets selling price",
                "identifies and removes unnecessary movements"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_2_m0280",
            question = "Which statement about functional foremanship is correct?",
            options = listOf(
                "uses specialised supervisors for different aspects of work",
                "uses no supervisors",
                "gives all authority to one worker",
                "is a method of advertising"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0281",
            question = "Which of the following best describes business environment?",
            options = listOf(
                "only internal staff",
                "only cash balance",
                "only production machinery",
                "external forces that affect business decisions and performance"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0282",
            question = "Which situation is most consistent with the concept of business environment?",
            options = listOf(
                "only internal staff",
                "only cash balance",
                "only production machinery",
                "external forces that affect business decisions and performance"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0283",
            question = "Which of the following best describes economic environment?",
            options = listOf(
                "includes income, interest rates, inflation and economic policies",
                "includes only social customs",
                "includes only technology",
                "includes only company culture"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0284",
            question = "Which of the following best describes social environment?",
            options = listOf(
                "includes only machines",
                "includes values, customs, demographics and lifestyles",
                "includes only tax laws",
                "includes only bank rates"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0285",
            question = "Which of the following best describes technological environment?",
            options = listOf(
                "includes only consumer income",
                "includes only taxation",
                "includes innovations and changes in production technology",
                "includes only political parties"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0286",
            question = "Which of the following best describes political environment?",
            options = listOf(
                "includes only packaging",
                "includes only wages",
                "includes only inventory",
                "includes government policy and political conditions"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0287",
            question = "Which of the following best describes legal environment?",
            options = listOf(
                "consists of laws and regulations affecting business",
                "consists only of consumer tastes",
                "consists only of technology",
                "consists only of demand"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0288",
            question = "Which of the following best describes liberalisation?",
            options = listOf(
                "ends foreign trade",
                "reduces unnecessary government restrictions on economic activity",
                "increases all restrictions",
                "bans private business"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0289",
            question = "Which of the following best describes privatisation?",
            options = listOf(
                "means banning private firms",
                "means fixing all prices",
                "increases the role of private ownership in economic activity",
                "means nationalisation"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0290",
            question = "Which of the following best describes globalisation?",
            options = listOf(
                "isolates domestic producers",
                "bans imports",
                "ends international competition",
                "integrates domestic markets with the world economy"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0291",
            question = "Which of the following best describes demonetisation?",
            options = listOf(
                "withdraws specified currency notes from legal tender status",
                "issues bonus shares",
                "reduces income tax",
                "privatises banks"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0292",
            question = "Which statement about business environment is correct?",
            options = listOf(
                "only production machinery",
                "external forces that affect business decisions and performance",
                "only internal staff",
                "only cash balance"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0293",
            question = "Which statement about economic environment is correct?",
            options = listOf(
                "includes only technology",
                "includes only company culture",
                "includes income, interest rates, inflation and economic policies",
                "includes only social customs"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0294",
            question = "Which statement about social environment is correct?",
            options = listOf(
                "includes only tax laws",
                "includes only bank rates",
                "includes only machines",
                "includes values, customs, demographics and lifestyles"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0295",
            question = "Which statement about technological environment is correct?",
            options = listOf(
                "includes innovations and changes in production technology",
                "includes only political parties",
                "includes only consumer income",
                "includes only taxation"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0296",
            question = "Which statement about political environment is correct?",
            options = listOf(
                "includes only inventory",
                "includes government policy and political conditions",
                "includes only packaging",
                "includes only wages"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0297",
            question = "Which statement about legal environment is correct?",
            options = listOf(
                "consists only of technology",
                "consists only of demand",
                "consists of laws and regulations affecting business",
                "consists only of consumer tastes"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0298",
            question = "Which statement about liberalisation is correct?",
            options = listOf(
                "increases all restrictions",
                "bans private business",
                "ends foreign trade",
                "reduces unnecessary government restrictions on economic activity"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0299",
            question = "Which statement about privatisation is correct?",
            options = listOf(
                "increases the role of private ownership in economic activity",
                "means nationalisation",
                "means banning private firms",
                "means fixing all prices"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0300",
            question = "Which statement about globalisation is correct?",
            options = listOf(
                "ends international competition",
                "integrates domestic markets with the world economy",
                "isolates domestic producers",
                "bans imports"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_3_m0301",
            question = "Which statement about demonetisation is correct?",
            options = listOf(
                "reduces income tax",
                "privatises banks",
                "withdraws specified currency notes from legal tender status",
                "issues bonus shares"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0302",
            question = "Which of the following best describes planning?",
            options = listOf(
                "recording past transactions",
                "auditing only",
                "recruiting only",
                "deciding in advance what is to be done, how, when and by whom"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0303",
            question = "Which situation is most consistent with the concept of planning?",
            options = listOf(
                "recording past transactions",
                "auditing only",
                "recruiting only",
                "deciding in advance what is to be done, how, when and by whom"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0304",
            question = "Which of the following best describes objective?",
            options = listOf(
                "a desired result that an organisation seeks to achieve",
                "a past transaction",
                "a legal penalty",
                "a cash receipt"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0305",
            question = "Which situation is most consistent with the concept of objective?",
            options = listOf(
                "a desired result that an organisation seeks to achieve",
                "a past transaction",
                "a legal penalty",
                "a cash receipt"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0306",
            question = "Which of the following best describes strategy?",
            options = listOf(
                "a bank reconciliation",
                "a broad plan designed to achieve organisational objectives",
                "a salary slip",
                "an invoice"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0307",
            question = "Which situation is most consistent with the concept of strategy?",
            options = listOf(
                "a bank reconciliation",
                "a broad plan designed to achieve organisational objectives",
                "a salary slip",
                "an invoice"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0308",
            question = "Which of the following best describes policy?",
            options = listOf(
                "a balance sheet",
                "a tax receipt",
                "a general guideline for managerial decisions",
                "a single mandatory step only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0309",
            question = "Which situation is most consistent with the concept of policy?",
            options = listOf(
                "a balance sheet",
                "a tax receipt",
                "a general guideline for managerial decisions",
                "a single mandatory step only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0310",
            question = "Which of the following best describes procedure?",
            options = listOf(
                "a broad mission only",
                "a market share",
                "a financial ratio",
                "a sequence of steps for handling recurring activities"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0311",
            question = "Which situation is most consistent with the concept of procedure?",
            options = listOf(
                "a broad mission only",
                "a market share",
                "a financial ratio",
                "a sequence of steps for handling recurring activities"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0312",
            question = "Which of the following best describes rule?",
            options = listOf(
                "a specific statement about what must or must not be done",
                "a flexible suggestion",
                "an annual report",
                "a long-term vision"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0313",
            question = "Which situation is most consistent with the concept of rule?",
            options = listOf(
                "a specific statement about what must or must not be done",
                "a flexible suggestion",
                "an annual report",
                "a long-term vision"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0314",
            question = "Which of the following best describes programme?",
            options = listOf(
                "only a balance sheet",
                "a detailed plan combining objectives, policies, procedures and resources",
                "only a rule",
                "only a ratio"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0315",
            question = "Which of the following best describes budget?",
            options = listOf(
                "a recruitment form",
                "an audit certificate",
                "a numerical statement of expected results",
                "a qualitative guideline only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0316",
            question = "Which of the following best describes planning reduces risk?",
            options = listOf(
                "it removes uncertainty completely",
                "it guarantees profit",
                "it eliminates competition",
                "it anticipates changes and prepares responses"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0317",
            question = "Which of the following best describes planning facilitates control?",
            options = listOf(
                "it provides standards against which actual performance can be compared",
                "it removes standards",
                "it prevents measurement",
                "it replaces feedback"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0318",
            question = "Which statement about planning is correct?",
            options = listOf(
                "recruiting only",
                "deciding in advance what is to be done, how, when and by whom",
                "recording past transactions",
                "auditing only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0319",
            question = "Which statement about objective is correct?",
            options = listOf(
                "a legal penalty",
                "a cash receipt",
                "a desired result that an organisation seeks to achieve",
                "a past transaction"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0320",
            question = "Which statement about strategy is correct?",
            options = listOf(
                "a salary slip",
                "an invoice",
                "a bank reconciliation",
                "a broad plan designed to achieve organisational objectives"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0321",
            question = "Which statement about policy is correct?",
            options = listOf(
                "a general guideline for managerial decisions",
                "a single mandatory step only",
                "a balance sheet",
                "a tax receipt"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0322",
            question = "Which statement about procedure is correct?",
            options = listOf(
                "a financial ratio",
                "a sequence of steps for handling recurring activities",
                "a broad mission only",
                "a market share"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0323",
            question = "Which statement about rule is correct?",
            options = listOf(
                "an annual report",
                "a long-term vision",
                "a specific statement about what must or must not be done",
                "a flexible suggestion"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0324",
            question = "Which statement about programme is correct?",
            options = listOf(
                "only a rule",
                "only a ratio",
                "only a balance sheet",
                "a detailed plan combining objectives, policies, procedures and resources"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0325",
            question = "Which statement about budget is correct?",
            options = listOf(
                "a numerical statement of expected results",
                "a qualitative guideline only",
                "a recruitment form",
                "an audit certificate"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0326",
            question = "Which statement about planning reduces risk is correct?",
            options = listOf(
                "it eliminates competition",
                "it anticipates changes and prepares responses",
                "it removes uncertainty completely",
                "it guarantees profit"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_4_m0327",
            question = "Which statement about planning facilitates control is correct?",
            options = listOf(
                "it prevents measurement",
                "it replaces feedback",
                "it provides standards against which actual performance can be compared",
                "it removes standards"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0328",
            question = "Which of the following best describes organising?",
            options = listOf(
                "only setting objectives",
                "only motivating staff",
                "only preparing accounts",
                "identifying work, grouping activities and establishing relationships"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0329",
            question = "Which situation is most consistent with the concept of organising?",
            options = listOf(
                "only preparing accounts",
                "identifying work, grouping activities and establishing relationships",
                "only setting objectives",
                "only motivating staff"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0330",
            question = "Which of the following best describes division of work?",
            options = listOf(
                "breaks total work into manageable activities and encourages specialisation",
                "eliminates specialisation",
                "stops delegation",
                "combines all jobs into one"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0331",
            question = "Which situation is most consistent with the concept of division of work?",
            options = listOf(
                "stops delegation",
                "combines all jobs into one",
                "breaks total work into manageable activities and encourages specialisation",
                "eliminates specialisation"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0332",
            question = "Which of the following best describes departmentalisation?",
            options = listOf(
                "audits accounts",
                "groups related activities into departments",
                "sets employee salaries",
                "calculates depreciation"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0333",
            question = "Which situation is most consistent with the concept of departmentalisation?",
            options = listOf(
                "sets employee salaries",
                "calculates depreciation",
                "audits accounts",
                "groups related activities into departments"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0334",
            question = "Which of the following best describes formal organisation?",
            options = listOf(
                "social group only",
                "customer network",
                "officially defined relationships of authority and responsibility",
                "friendship network"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0335",
            question = "Which situation is most consistent with the concept of formal organisation?",
            options = listOf(
                "officially defined relationships of authority and responsibility",
                "friendship network",
                "social group only",
                "customer network"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0336",
            question = "Which of the following best describes informal organisation?",
            options = listOf(
                "is created only by written rules",
                "is shown only in the balance sheet",
                "is a legal contract",
                "arises from social interaction among employees"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0337",
            question = "Which situation is most consistent with the concept of informal organisation?",
            options = listOf(
                "is a legal contract",
                "arises from social interaction among employees",
                "is created only by written rules",
                "is shown only in the balance sheet"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0338",
            question = "Which of the following best describes delegation?",
            options = listOf(
                "transfer of authority while the superior retains ultimate accountability",
                "transfer of ownership",
                "transfer of all accountability",
                "removal of responsibility"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0339",
            question = "Which situation is most consistent with the concept of delegation?",
            options = listOf(
                "transfer of all accountability",
                "removal of responsibility",
                "transfer of authority while the superior retains ultimate accountability",
                "transfer of ownership"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0340",
            question = "Which of the following best describes authority?",
            options = listOf(
                "personal friendship",
                "right to give orders and make decisions",
                "obligation to obey only",
                "profit share"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0341",
            question = "Which of the following best describes responsibility?",
            options = listOf(
                "market demand",
                "capital contribution",
                "obligation to perform an assigned task",
                "right to command only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0342",
            question = "Which of the following best describes accountability?",
            options = listOf(
                "right to issue shares",
                "ability to advertise",
                "cash balance",
                "answerability for the final performance of an assigned responsibility"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0343",
            question = "Which of the following best describes decentralisation?",
            options = listOf(
                "systematic dispersal of authority to lower levels",
                "complete central control",
                "elimination of managers",
                "removal of responsibility"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0344",
            question = "Which of the following best describes functional structure?",
            options = listOf(
                "groups only by personal friendship",
                "groups jobs according to specialised functions",
                "groups only by colour",
                "groups only by age"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0345",
            question = "Which statement about organising is correct?",
            options = listOf(
                "only motivating staff",
                "only preparing accounts",
                "identifying work, grouping activities and establishing relationships",
                "only setting objectives"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0346",
            question = "Which statement about division of work is correct?",
            options = listOf(
                "eliminates specialisation",
                "stops delegation",
                "combines all jobs into one",
                "breaks total work into manageable activities and encourages specialisation"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0347",
            question = "Which statement about departmentalisation is correct?",
            options = listOf(
                "groups related activities into departments",
                "sets employee salaries",
                "calculates depreciation",
                "audits accounts"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0348",
            question = "Which statement about formal organisation is correct?",
            options = listOf(
                "customer network",
                "officially defined relationships of authority and responsibility",
                "friendship network",
                "social group only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0349",
            question = "Which statement about informal organisation is correct?",
            options = listOf(
                "is shown only in the balance sheet",
                "is a legal contract",
                "arises from social interaction among employees",
                "is created only by written rules"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0350",
            question = "Which statement about delegation is correct?",
            options = listOf(
                "transfer of ownership",
                "transfer of all accountability",
                "removal of responsibility",
                "transfer of authority while the superior retains ultimate accountability"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0351",
            question = "Which statement about authority is correct?",
            options = listOf(
                "right to give orders and make decisions",
                "obligation to obey only",
                "profit share",
                "personal friendship"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0352",
            question = "Which statement about responsibility is correct?",
            options = listOf(
                "capital contribution",
                "obligation to perform an assigned task",
                "right to command only",
                "market demand"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0353",
            question = "Which statement about accountability is correct?",
            options = listOf(
                "ability to advertise",
                "cash balance",
                "answerability for the final performance of an assigned responsibility",
                "right to issue shares"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0354",
            question = "Which statement about decentralisation is correct?",
            options = listOf(
                "complete central control",
                "elimination of managers",
                "removal of responsibility",
                "systematic dispersal of authority to lower levels"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_5_m0355",
            question = "Which statement about functional structure is correct?",
            options = listOf(
                "groups jobs according to specialised functions",
                "groups only by colour",
                "groups only by age",
                "groups only by personal friendship"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0356",
            question = "Which of the following best describes staffing?",
            options = listOf(
                "only paying wages",
                "only advertising products",
                "only preparing budgets",
                "obtaining, developing and maintaining a competent workforce"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0357",
            question = "Which situation is most consistent with the concept of staffing?",
            options = listOf(
                "only preparing budgets",
                "obtaining, developing and maintaining a competent workforce",
                "only paying wages",
                "only advertising products"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0358",
            question = "Which of the following best describes recruitment?",
            options = listOf(
                "searching for prospective employees and encouraging them to apply",
                "final selection only",
                "training only",
                "promotion only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0359",
            question = "Which situation is most consistent with the concept of recruitment?",
            options = listOf(
                "training only",
                "promotion only",
                "searching for prospective employees and encouraging them to apply",
                "final selection only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0360",
            question = "Which of the following best describes internal recruitment?",
            options = listOf(
                "requires no records",
                "fills vacancies from existing employees",
                "uses only outsiders",
                "always costs more"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0361",
            question = "Which situation is most consistent with the concept of internal recruitment?",
            options = listOf(
                "uses only outsiders",
                "always costs more",
                "requires no records",
                "fills vacancies from existing employees"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0362",
            question = "Which of the following best describes external recruitment?",
            options = listOf(
                "means promotion only",
                "means transfer only",
                "attracts candidates from outside the organisation",
                "uses only existing employees"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0363",
            question = "Which situation is most consistent with the concept of external recruitment?",
            options = listOf(
                "attracts candidates from outside the organisation",
                "uses only existing employees",
                "means promotion only",
                "means transfer only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0364",
            question = "Which of the following best describes selection?",
            options = listOf(
                "creating a vacancy",
                "advertising a product",
                "setting a price",
                "choosing the most suitable candidate from applicants"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0365",
            question = "Which of the following best describes selection test?",
            options = listOf(
                "assesses candidate abilities or suitability",
                "guarantees future profit",
                "sets wages",
                "replaces every other selection step"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0366",
            question = "Which of the following best describes interview?",
            options = listOf(
                "stock valuation",
                "direct interaction used to obtain information about a candidate",
                "financial audit",
                "market survey"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0367",
            question = "Which of the following best describes training?",
            options = listOf(
                "means dismissal",
                "means advertising",
                "improves skills and performance for present work",
                "means retirement"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0368",
            question = "Which of the following best describes development?",
            options = listOf(
                "only reduces salary",
                "means retirement",
                "means product promotion",
                "prepares employees for future responsibilities"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0369",
            question = "Which of the following best describes on-the-job training?",
            options = listOf(
                "takes place at the actual workplace while performing work",
                "takes place only in a distant classroom",
                "is only a written test",
                "is only a promotion"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0370",
            question = "Which of the following best describes performance appraisal?",
            options = listOf(
                "inventory valuation",
                "systematic evaluation of employee performance",
                "market research",
                "capital budgeting"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0371",
            question = "Which statement about staffing is correct?",
            options = listOf(
                "only advertising products",
                "only preparing budgets",
                "obtaining, developing and maintaining a competent workforce",
                "only paying wages"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0372",
            question = "Which statement about recruitment is correct?",
            options = listOf(
                "final selection only",
                "training only",
                "promotion only",
                "searching for prospective employees and encouraging them to apply"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0373",
            question = "Which statement about internal recruitment is correct?",
            options = listOf(
                "fills vacancies from existing employees",
                "uses only outsiders",
                "always costs more",
                "requires no records"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0374",
            question = "Which statement about external recruitment is correct?",
            options = listOf(
                "means transfer only",
                "attracts candidates from outside the organisation",
                "uses only existing employees",
                "means promotion only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0375",
            question = "Which statement about selection is correct?",
            options = listOf(
                "advertising a product",
                "setting a price",
                "choosing the most suitable candidate from applicants",
                "creating a vacancy"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0376",
            question = "Which statement about selection test is correct?",
            options = listOf(
                "guarantees future profit",
                "sets wages",
                "replaces every other selection step",
                "assesses candidate abilities or suitability"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0377",
            question = "Which statement about interview is correct?",
            options = listOf(
                "direct interaction used to obtain information about a candidate",
                "financial audit",
                "market survey",
                "stock valuation"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0378",
            question = "Which statement about training is correct?",
            options = listOf(
                "means advertising",
                "improves skills and performance for present work",
                "means retirement",
                "means dismissal"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0379",
            question = "Which statement about development is correct?",
            options = listOf(
                "means retirement",
                "means product promotion",
                "prepares employees for future responsibilities",
                "only reduces salary"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0380",
            question = "Which statement about on-the-job training is correct?",
            options = listOf(
                "takes place only in a distant classroom",
                "is only a written test",
                "is only a promotion",
                "takes place at the actual workplace while performing work"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_6_m0381",
            question = "Which statement about performance appraisal is correct?",
            options = listOf(
                "systematic evaluation of employee performance",
                "market research",
                "capital budgeting",
                "inventory valuation"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0382",
            question = "Which of the following best describes directing?",
            options = listOf(
                "preparing accounts",
                "issuing shares",
                "auditing",
                "guiding, instructing, motivating and leading employees"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0383",
            question = "Which of the following best describes supervision?",
            options = listOf(
                "overseeing employees while they perform their work",
                "setting share price",
                "preparing tax returns",
                "buying machinery"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0384",
            question = "Which of the following best describes motivation?",
            options = listOf(
                "eliminating feedback",
                "stimulating people to work willingly towards organisational goals",
                "reducing communication",
                "avoiding rewards"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0385",
            question = "Which of the following best describes financial incentive?",
            options = listOf(
                "job enrichment only",
                "participation only",
                "a reward involving money",
                "recognition certificate only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0386",
            question = "Which of the following best describes non-financial incentive?",
            options = listOf(
                "cash bonus only",
                "commission only",
                "profit share only",
                "a reward such as recognition, status or job enrichment"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0387",
            question = "Which of the following best describes leadership?",
            options = listOf(
                "process of influencing people to achieve organisational objectives",
                "recording transactions",
                "calculating tax",
                "purchasing inventory"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0388",
            question = "Which of the following best describes autocratic leadership?",
            options = listOf(
                "no authority exists",
                "leader takes decisions with little subordinate participation",
                "all decisions are made by a group",
                "employees always decide alone"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0389",
            question = "Which of the following best describes democratic leadership?",
            options = listOf(
                "requires no communication",
                "removes all authority",
                "involves subordinates in decision making",
                "excludes employees"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0390",
            question = "Which of the following best describes communication?",
            options = listOf(
                "only giving orders",
                "only writing reports",
                "only advertising",
                "exchange of information and understanding"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0391",
            question = "Which of the following best describes formal communication?",
            options = listOf(
                "follows official organisational channels",
                "is always personal",
                "is never documented",
                "is only social"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0392",
            question = "Which of the following best describes grapevine?",
            options = listOf(
                "a legal notice",
                "an informal communication network",
                "a formal chain of command",
                "a financial statement"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0393",
            question = "Which statement about directing is correct?",
            options = listOf(
                "issuing shares",
                "auditing",
                "guiding, instructing, motivating and leading employees",
                "preparing accounts"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0394",
            question = "Which statement about supervision is correct?",
            options = listOf(
                "setting share price",
                "preparing tax returns",
                "buying machinery",
                "overseeing employees while they perform their work"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0395",
            question = "Which statement about motivation is correct?",
            options = listOf(
                "stimulating people to work willingly towards organisational goals",
                "reducing communication",
                "avoiding rewards",
                "eliminating feedback"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0396",
            question = "Which statement about financial incentive is correct?",
            options = listOf(
                "participation only",
                "a reward involving money",
                "recognition certificate only",
                "job enrichment only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0397",
            question = "Which statement about non-financial incentive is correct?",
            options = listOf(
                "commission only",
                "profit share only",
                "a reward such as recognition, status or job enrichment",
                "cash bonus only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0398",
            question = "Which statement about leadership is correct?",
            options = listOf(
                "recording transactions",
                "calculating tax",
                "purchasing inventory",
                "process of influencing people to achieve organisational objectives"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0399",
            question = "Which statement about autocratic leadership is correct?",
            options = listOf(
                "leader takes decisions with little subordinate participation",
                "all decisions are made by a group",
                "employees always decide alone",
                "no authority exists"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0400",
            question = "Which statement about democratic leadership is correct?",
            options = listOf(
                "removes all authority",
                "involves subordinates in decision making",
                "excludes employees",
                "requires no communication"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0401",
            question = "Which statement about communication is correct?",
            options = listOf(
                "only writing reports",
                "only advertising",
                "exchange of information and understanding",
                "only giving orders"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0402",
            question = "Which statement about formal communication is correct?",
            options = listOf(
                "is always personal",
                "is never documented",
                "is only social",
                "follows official organisational channels"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_7_m0403",
            question = "Which statement about grapevine is correct?",
            options = listOf(
                "an informal communication network",
                "a formal chain of command",
                "a financial statement",
                "a legal notice"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0404",
            question = "Which of the following best describes controlling?",
            options = listOf(
                "only planning",
                "only staffing",
                "only recruitment",
                "ensuring that actual performance conforms to planned standards"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0405",
            question = "Which situation is most consistent with the concept of controlling?",
            options = listOf(
                "only planning",
                "only staffing",
                "only recruitment",
                "ensuring that actual performance conforms to planned standards"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0406",
            question = "Which of the following best describes standard?",
            options = listOf(
                "predetermined level of expected performance",
                "actual result",
                "past expense",
                "market price"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0407",
            question = "Which situation is most consistent with the concept of standard?",
            options = listOf(
                "predetermined level of expected performance",
                "actual result",
                "past expense",
                "market price"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0408",
            question = "Which of the following best describes measurement?",
            options = listOf(
                "recruiting",
                "determining actual performance",
                "setting objectives only",
                "delegating authority"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0409",
            question = "Which of the following best describes comparison?",
            options = listOf(
                "issuing shares",
                "advertising",
                "finding the difference between actual performance and standards",
                "paying wages"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0410",
            question = "Which of the following best describes deviation?",
            options = listOf(
                "profit only",
                "sales only",
                "capital only",
                "difference between actual performance and the standard"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0411",
            question = "Which of the following best describes corrective action?",
            options = listOf(
                "removes causes of significant deviations",
                "sets the original objective",
                "recruits all staff",
                "prepares annual reports"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0412",
            question = "Which of the following best describes critical point control?",
            options = listOf(
                "eliminates measurement",
                "focuses attention on key areas where deviations matter most",
                "checks every tiny detail equally",
                "avoids standards"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0413",
            question = "Which of the following best describes management by exception?",
            options = listOf(
                "controls only cash",
                "eliminates feedback",
                "focuses managerial attention on significant deviations",
                "ignores every deviation"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0414",
            question = "Which of the following best describes planning and controlling?",
            options = listOf(
                "are unrelated",
                "cannot coexist",
                "replace each other",
                "are closely related because plans provide standards for control"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0415",
            question = "Which of the following best describes controlling is continuous?",
            options = listOf(
                "performance is monitored and corrective action may be needed repeatedly",
                "control happens only once",
                "standards never change",
                "feedback is unnecessary"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0416",
            question = "Which statement about controlling is correct?",
            options = listOf(
                "only recruitment",
                "ensuring that actual performance conforms to planned standards",
                "only planning",
                "only staffing"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0417",
            question = "Which statement about standard is correct?",
            options = listOf(
                "past expense",
                "market price",
                "predetermined level of expected performance",
                "actual result"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0418",
            question = "Which statement about measurement is correct?",
            options = listOf(
                "setting objectives only",
                "delegating authority",
                "recruiting",
                "determining actual performance"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0419",
            question = "Which statement about comparison is correct?",
            options = listOf(
                "finding the difference between actual performance and standards",
                "paying wages",
                "issuing shares",
                "advertising"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0420",
            question = "Which statement about deviation is correct?",
            options = listOf(
                "capital only",
                "difference between actual performance and the standard",
                "profit only",
                "sales only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0421",
            question = "Which statement about corrective action is correct?",
            options = listOf(
                "recruits all staff",
                "prepares annual reports",
                "removes causes of significant deviations",
                "sets the original objective"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0422",
            question = "Which statement about critical point control is correct?",
            options = listOf(
                "checks every tiny detail equally",
                "avoids standards",
                "eliminates measurement",
                "focuses attention on key areas where deviations matter most"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0423",
            question = "Which statement about management by exception is correct?",
            options = listOf(
                "focuses managerial attention on significant deviations",
                "ignores every deviation",
                "controls only cash",
                "eliminates feedback"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0424",
            question = "Which statement about planning and controlling is correct?",
            options = listOf(
                "replace each other",
                "are closely related because plans provide standards for control",
                "are unrelated",
                "cannot coexist"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_8_m0425",
            question = "Which statement about controlling is continuous is correct?",
            options = listOf(
                "standards never change",
                "feedback is unnecessary",
                "performance is monitored and corrective action may be needed repeatedly",
                "control happens only once"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0426",
            question = "Which of the following best describes financial management?",
            options = listOf(
                "only bookkeeping",
                "only advertising",
                "only recruitment",
                "procurement and effective utilisation of funds"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0427",
            question = "Which situation is most consistent with the concept of financial management?",
            options = listOf(
                "only recruitment",
                "procurement and effective utilisation of funds",
                "only bookkeeping",
                "only advertising"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0428",
            question = "Which of the following best describes investment decision?",
            options = listOf(
                "decides where funds should be invested",
                "decides employee salaries",
                "decides packaging",
                "decides advertising slogans"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0429",
            question = "Which situation is most consistent with the concept of investment decision?",
            options = listOf(
                "decides packaging",
                "decides advertising slogans",
                "decides where funds should be invested",
                "decides employee salaries"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0430",
            question = "Which of the following best describes financing decision?",
            options = listOf(
                "decides market segment",
                "decides the sources from which funds should be raised",
                "decides product colour",
                "decides employee training"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0431",
            question = "Which situation is most consistent with the concept of financing decision?",
            options = listOf(
                "decides product colour",
                "decides employee training",
                "decides market segment",
                "decides the sources from which funds should be raised"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0432",
            question = "Which of the following best describes dividend decision?",
            options = listOf(
                "concerns only borrowing",
                "concerns product design",
                "concerns distribution of profits to shareholders",
                "concerns recruitment"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0433",
            question = "Which situation is most consistent with the concept of dividend decision?",
            options = listOf(
                "concerns distribution of profits to shareholders",
                "concerns recruitment",
                "concerns only borrowing",
                "concerns product design"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0434",
            question = "Which of the following best describes financial planning?",
            options = listOf(
                "records past cash only",
                "sets product quality",
                "selects employees",
                "estimates fund requirements and possible sources"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0435",
            question = "Which of the following best describes capital structure?",
            options = listOf(
                "mix of debt and equity financing",
                "mix of products",
                "mix of customers",
                "mix of employees"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0436",
            question = "Which of the following best describes working capital?",
            options = listOf(
                "only reserves",
                "funds required for day-to-day operations",
                "only long-term assets",
                "only share premium"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0437",
            question = "Which of the following best describes fixed capital?",
            options = listOf(
                "wages only",
                "inventory only",
                "funds invested in long-term assets",
                "daily expenses"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0438",
            question = "Which of the following best describes financial risk?",
            options = listOf(
                "risk from advertising only",
                "risk from packaging only",
                "risk from recruitment only",
                "risk associated with fixed financial charges such as interest on debt"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0439",
            question = "Which of the following best describes wealth maximisation?",
            options = listOf(
                "aims at increasing shareholders' market value",
                "ignores risk",
                "ignores future cash flows",
                "means maximum sales only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0440",
            question = "Which of the following best describes investment appraisal?",
            options = listOf(
                "evaluates suppliers only",
                "evaluates long-term investment proposals",
                "evaluates employees",
                "evaluates advertisements"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0441",
            question = "Which statement about financial management is correct?",
            options = listOf(
                "only advertising",
                "only recruitment",
                "procurement and effective utilisation of funds",
                "only bookkeeping"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0442",
            question = "Which statement about investment decision is correct?",
            options = listOf(
                "decides employee salaries",
                "decides packaging",
                "decides advertising slogans",
                "decides where funds should be invested"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0443",
            question = "Which statement about financing decision is correct?",
            options = listOf(
                "decides the sources from which funds should be raised",
                "decides product colour",
                "decides employee training",
                "decides market segment"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0444",
            question = "Which statement about dividend decision is correct?",
            options = listOf(
                "concerns product design",
                "concerns distribution of profits to shareholders",
                "concerns recruitment",
                "concerns only borrowing"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0445",
            question = "Which statement about financial planning is correct?",
            options = listOf(
                "sets product quality",
                "selects employees",
                "estimates fund requirements and possible sources",
                "records past cash only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0446",
            question = "Which statement about capital structure is correct?",
            options = listOf(
                "mix of products",
                "mix of customers",
                "mix of employees",
                "mix of debt and equity financing"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0447",
            question = "Which statement about working capital is correct?",
            options = listOf(
                "funds required for day-to-day operations",
                "only long-term assets",
                "only share premium",
                "only reserves"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0448",
            question = "Which statement about fixed capital is correct?",
            options = listOf(
                "inventory only",
                "funds invested in long-term assets",
                "daily expenses",
                "wages only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0449",
            question = "Which statement about financial risk is correct?",
            options = listOf(
                "risk from packaging only",
                "risk from recruitment only",
                "risk associated with fixed financial charges such as interest on debt",
                "risk from advertising only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0450",
            question = "Which statement about wealth maximisation is correct?",
            options = listOf(
                "ignores risk",
                "ignores future cash flows",
                "means maximum sales only",
                "aims at increasing shareholders' market value"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_9_m0451",
            question = "Which statement about investment appraisal is correct?",
            options = listOf(
                "evaluates long-term investment proposals",
                "evaluates employees",
                "evaluates advertisements",
                "evaluates suppliers only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0452",
            question = "Which of the following best describes financial market?",
            options = listOf(
                "market for vegetables",
                "market for labour only",
                "market for machines only",
                "market for creation and exchange of financial assets"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0453",
            question = "Which situation is most consistent with the concept of financial market?",
            options = listOf(
                "market for machines only",
                "market for creation and exchange of financial assets",
                "market for vegetables",
                "market for labour only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0454",
            question = "Which of the following best describes money market?",
            options = listOf(
                "market for short-term funds and instruments",
                "market only for long-term shares",
                "market for land",
                "market for consumer goods"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0455",
            question = "Which situation is most consistent with the concept of money market?",
            options = listOf(
                "market for land",
                "market for consumer goods",
                "market for short-term funds and instruments",
                "market only for long-term shares"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0456",
            question = "Which of the following best describes capital market?",
            options = listOf(
                "market for raw materials",
                "market for medium- and long-term funds",
                "market only for daily cash",
                "market for wages"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0457",
            question = "Which situation is most consistent with the concept of capital market?",
            options = listOf(
                "market only for daily cash",
                "market for wages",
                "market for raw materials",
                "market for medium- and long-term funds"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0458",
            question = "Which of the following best describes primary market?",
            options = listOf(
                "market for currency notes",
                "market for used machines",
                "market where new securities are issued",
                "market for existing securities only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0459",
            question = "Which situation is most consistent with the concept of primary market?",
            options = listOf(
                "market where new securities are issued",
                "market for existing securities only",
                "market for currency notes",
                "market for used machines"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0460",
            question = "Which of the following best describes secondary market?",
            options = listOf(
                "market where only new shares are issued",
                "market where currency is printed",
                "market where taxes are collected",
                "market where existing securities are traded"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0461",
            question = "Which of the following best describes stock exchange?",
            options = listOf(
                "organised market for trading eligible securities",
                "market for vegetables",
                "bank branch",
                "insurance office"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0462",
            question = "Which of the following best describes SEBI?",
            options = listOf(
                "issues currency",
                "regulates the securities market and protects investors",
                "controls monetary policy",
                "collects income tax"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0463",
            question = "Which of the following best describes treasury bill?",
            options = listOf(
                "consumer loan",
                "insurance policy",
                "short-term government money-market instrument",
                "long-term equity share"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0464",
            question = "Which of the following best describes commercial paper?",
            options = listOf(
                "government currency",
                "long-term equity share",
                "insurance contract",
                "short-term unsecured instrument issued by eligible companies"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0465",
            question = "Which of the following best describes call money?",
            options = listOf(
                "very short-term borrowing, especially among banks",
                "long-term mortgage",
                "consumer credit",
                "equity capital"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0466",
            question = "Which of the following best describes liquidity?",
            options = listOf(
                "tax liability",
                "ease of converting an asset into cash without major loss",
                "profitability only",
                "ownership only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0467",
            question = "Which statement about financial market is correct?",
            options = listOf(
                "market for labour only",
                "market for machines only",
                "market for creation and exchange of financial assets",
                "market for vegetables"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0468",
            question = "Which statement about money market is correct?",
            options = listOf(
                "market only for long-term shares",
                "market for land",
                "market for consumer goods",
                "market for short-term funds and instruments"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0469",
            question = "Which statement about capital market is correct?",
            options = listOf(
                "market for medium- and long-term funds",
                "market only for daily cash",
                "market for wages",
                "market for raw materials"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0470",
            question = "Which statement about primary market is correct?",
            options = listOf(
                "market for used machines",
                "market where new securities are issued",
                "market for existing securities only",
                "market for currency notes"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0471",
            question = "Which statement about secondary market is correct?",
            options = listOf(
                "market where currency is printed",
                "market where taxes are collected",
                "market where existing securities are traded",
                "market where only new shares are issued"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0472",
            question = "Which statement about stock exchange is correct?",
            options = listOf(
                "market for vegetables",
                "bank branch",
                "insurance office",
                "organised market for trading eligible securities"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0473",
            question = "Which statement about SEBI is correct?",
            options = listOf(
                "regulates the securities market and protects investors",
                "controls monetary policy",
                "collects income tax",
                "issues currency"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0474",
            question = "Which statement about treasury bill is correct?",
            options = listOf(
                "insurance policy",
                "short-term government money-market instrument",
                "long-term equity share",
                "consumer loan"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0475",
            question = "Which statement about commercial paper is correct?",
            options = listOf(
                "long-term equity share",
                "insurance contract",
                "short-term unsecured instrument issued by eligible companies",
                "government currency"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0476",
            question = "Which statement about call money is correct?",
            options = listOf(
                "long-term mortgage",
                "consumer credit",
                "equity capital",
                "very short-term borrowing, especially among banks"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_10_m0477",
            question = "Which statement about liquidity is correct?",
            options = listOf(
                "ease of converting an asset into cash without major loss",
                "profitability only",
                "ownership only",
                "tax liability"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0478",
            question = "Which of the following best describes marketing?",
            options = listOf(
                "only selling",
                "only production",
                "only bookkeeping",
                "process of identifying and satisfying customer needs profitably"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0479",
            question = "Which situation is most consistent with the concept of marketing?",
            options = listOf(
                "only selling",
                "only production",
                "only bookkeeping",
                "process of identifying and satisfying customer needs profitably"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0480",
            question = "Which of the following best describes market?",
            options = listOf(
                "group of actual and potential buyers of a product",
                "only sellers",
                "only employees",
                "only factories"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0481",
            question = "Which situation is most consistent with the concept of market?",
            options = listOf(
                "group of actual and potential buyers of a product",
                "only sellers",
                "only employees",
                "only factories"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0482",
            question = "Which of the following best describes marketing mix?",
            options = listOf(
                "only distribution",
                "combination of controllable marketing variables",
                "only pricing",
                "only promotion"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0483",
            question = "Which of the following best describes product?",
            options = listOf(
                "only brand name",
                "only advertisement",
                "bundle of utility offered to satisfy a need or want",
                "only physical package"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0484",
            question = "Which of the following best describes branding?",
            options = listOf(
                "reducing quality",
                "setting wages",
                "recording sales",
                "giving a product a distinct identity"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0485",
            question = "Which of the following best describes packaging?",
            options = listOf(
                "designing and producing the container or wrapper",
                "only transport",
                "only pricing",
                "only recruitment"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0486",
            question = "Which of the following best describes labelling?",
            options = listOf(
                "creates capital",
                "provides information about the product on its package",
                "sets interest rates",
                "hires employees"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0487",
            question = "Which of the following best describes price?",
            options = listOf(
                "only profit",
                "only tax",
                "amount of money charged for a product",
                "only cost to seller"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0488",
            question = "Which of the following best describes physical distribution?",
            options = listOf(
                "only advertising",
                "only branding",
                "only product design",
                "movement of goods from producer to customer"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0489",
            question = "Which of the following best describes promotion?",
            options = listOf(
                "communicates product information and persuades customers",
                "only production",
                "only accounting",
                "only recruitment"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0490",
            question = "Which of the following best describes advertising?",
            options = listOf(
                "sales return",
                "paid non-personal presentation and promotion of an identified sponsor",
                "personal selling only",
                "free publicity only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0491",
            question = "Which of the following best describes personal selling?",
            options = listOf(
                "packaging",
                "pricing",
                "oral presentation to prospective buyers for making sales",
                "mass advertising only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0492",
            question = "Which of the following best describes sales promotion?",
            options = listOf(
                "long-term capital planning",
                "recruitment",
                "auditing",
                "short-term incentives used to encourage sales"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0493",
            question = "Which of the following best describes public relations?",
            options = listOf(
                "builds favourable relations and a positive image for the organisation",
                "only direct selling",
                "only price cutting",
                "only production"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0494",
            question = "Which statement about marketing is correct?",
            options = listOf(
                "only bookkeeping",
                "process of identifying and satisfying customer needs profitably",
                "only selling",
                "only production"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0495",
            question = "Which statement about market is correct?",
            options = listOf(
                "only employees",
                "only factories",
                "group of actual and potential buyers of a product",
                "only sellers"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0496",
            question = "Which statement about marketing mix is correct?",
            options = listOf(
                "only pricing",
                "only promotion",
                "only distribution",
                "combination of controllable marketing variables"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0497",
            question = "Which statement about product is correct?",
            options = listOf(
                "bundle of utility offered to satisfy a need or want",
                "only physical package",
                "only brand name",
                "only advertisement"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0498",
            question = "Which statement about branding is correct?",
            options = listOf(
                "recording sales",
                "giving a product a distinct identity",
                "reducing quality",
                "setting wages"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0499",
            question = "Which statement about packaging is correct?",
            options = listOf(
                "only pricing",
                "only recruitment",
                "designing and producing the container or wrapper",
                "only transport"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0500",
            question = "Which statement about labelling is correct?",
            options = listOf(
                "sets interest rates",
                "hires employees",
                "creates capital",
                "provides information about the product on its package"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0501",
            question = "Which statement about price is correct?",
            options = listOf(
                "amount of money charged for a product",
                "only cost to seller",
                "only profit",
                "only tax"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0502",
            question = "Which statement about physical distribution is correct?",
            options = listOf(
                "only product design",
                "movement of goods from producer to customer",
                "only advertising",
                "only branding"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0503",
            question = "Which statement about promotion is correct?",
            options = listOf(
                "only accounting",
                "only recruitment",
                "communicates product information and persuades customers",
                "only production"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0504",
            question = "Which statement about advertising is correct?",
            options = listOf(
                "personal selling only",
                "free publicity only",
                "sales return",
                "paid non-personal presentation and promotion of an identified sponsor"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0505",
            question = "Which statement about personal selling is correct?",
            options = listOf(
                "oral presentation to prospective buyers for making sales",
                "mass advertising only",
                "packaging",
                "pricing"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0506",
            question = "Which statement about sales promotion is correct?",
            options = listOf(
                "auditing",
                "short-term incentives used to encourage sales",
                "long-term capital planning",
                "recruitment"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_11_m0507",
            question = "Which statement about public relations is correct?",
            options = listOf(
                "only price cutting",
                "only production",
                "builds favourable relations and a positive image for the organisation",
                "only direct selling"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0508",
            question = "Which of the following best describes consumer protection?",
            options = listOf(
                "protecting only producers",
                "reducing all taxes",
                "raising all prices",
                "protecting consumers against unfair trade practices and exploitation"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0509",
            question = "Which of the following best describes right to safety?",
            options = listOf(
                "protection against hazardous goods and services",
                "right to free goods",
                "right to unlimited credit",
                "right to avoid payment"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0510",
            question = "Which of the following best describes right to information?",
            options = listOf(
                "right to free transport",
                "right to know quality, quantity, price and relevant product details",
                "right to hide defects",
                "right to unlimited discount"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0511",
            question = "Which of the following best describes right to choose?",
            options = listOf(
                "right to avoid bills",
                "right to set all taxes",
                "access to a variety of goods and services at competitive prices",
                "right to force a seller"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0512",
            question = "Which of the following best describes right to be heard?",
            options = listOf(
                "seller must always agree to every demand",
                "consumer sets all prices",
                "consumer becomes owner",
                "consumer interests should receive due consideration"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0513",
            question = "Which of the following best describes right to seek redressal?",
            options = listOf(
                "right to seek relief against unfair practices",
                "right to avoid evidence",
                "right to stop competition",
                "right to demand any product free"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0514",
            question = "Which of the following best describes consumer education?",
            options = listOf(
                "only taxation",
                "knowledge of consumer rights, responsibilities and remedies",
                "only school attendance",
                "only advertising"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0515",
            question = "Which of the following best describes standardisation?",
            options = listOf(
                "sets market price",
                "is a bank licence",
                "certification helps indicate conformity to prescribed standards",
                "guarantees profit"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0516",
            question = "Which of the following best describes AGMARK?",
            options = listOf(
                "banking certificate",
                "insurance licence",
                "company registration",
                "quality certification associated with agricultural products"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0517",
            question = "Which of the following best describes Hallmark?",
            options = listOf(
                "certification of purity of precious metals",
                "food safety mark",
                "bank certificate",
                "tax receipt"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0518",
            question = "Which of the following best describes consumer organisation?",
            options = listOf(
                "only lends money",
                "educates and assists consumers and may help pursue grievances",
                "only sells products",
                "only collects taxes"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0519",
            question = "Which statement about consumer protection is correct?",
            options = listOf(
                "reducing all taxes",
                "raising all prices",
                "protecting consumers against unfair trade practices and exploitation",
                "protecting only producers"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0520",
            question = "Which statement about right to safety is correct?",
            options = listOf(
                "right to free goods",
                "right to unlimited credit",
                "right to avoid payment",
                "protection against hazardous goods and services"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0521",
            question = "Which statement about right to information is correct?",
            options = listOf(
                "right to know quality, quantity, price and relevant product details",
                "right to hide defects",
                "right to unlimited discount",
                "right to free transport"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0522",
            question = "Which statement about right to choose is correct?",
            options = listOf(
                "right to set all taxes",
                "access to a variety of goods and services at competitive prices",
                "right to force a seller",
                "right to avoid bills"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0523",
            question = "Which statement about right to be heard is correct?",
            options = listOf(
                "consumer sets all prices",
                "consumer becomes owner",
                "consumer interests should receive due consideration",
                "seller must always agree to every demand"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0524",
            question = "Which statement about right to seek redressal is correct?",
            options = listOf(
                "right to avoid evidence",
                "right to stop competition",
                "right to demand any product free",
                "right to seek relief against unfair practices"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0525",
            question = "Which statement about consumer education is correct?",
            options = listOf(
                "knowledge of consumer rights, responsibilities and remedies",
                "only school attendance",
                "only advertising",
                "only taxation"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0526",
            question = "Which statement about standardisation is correct?",
            options = listOf(
                "is a bank licence",
                "certification helps indicate conformity to prescribed standards",
                "guarantees profit",
                "sets market price"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0527",
            question = "Which statement about AGMARK is correct?",
            options = listOf(
                "insurance licence",
                "company registration",
                "quality certification associated with agricultural products",
                "banking certificate"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0528",
            question = "Which statement about Hallmark is correct?",
            options = listOf(
                "food safety mark",
                "bank certificate",
                "tax receipt",
                "certification of purity of precious metals"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "business_studies_class_12_12_m0529",
            question = "Which statement about consumer organisation is correct?",
            options = listOf(
                "educates and assists consumers and may help pursue grievances",
                "only sells products",
                "only collects taxes",
                "only lends money"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "business_studies",
            chapterId = "business_studies_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0530",
            question = "Which of the following best describes economics?",
            options = listOf(
                "study of only money",
                "study of only accounting",
                "study of weather",
                "study of allocation of scarce resources among competing uses"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0531",
            question = "Which situation is most consistent with the concept of economics?",
            options = listOf(
                "study of only money",
                "study of only accounting",
                "study of weather",
                "study of allocation of scarce resources among competing uses"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0532",
            question = "Which of the following best describes scarcity?",
            options = listOf(
                "resources are limited relative to human wants",
                "wants are limited",
                "resources are unlimited",
                "prices are always fixed"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0533",
            question = "Which situation is most consistent with the concept of scarcity?",
            options = listOf(
                "resources are limited relative to human wants",
                "wants are limited",
                "resources are unlimited",
                "prices are always fixed"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0534",
            question = "Which of the following best describes choice?",
            options = listOf(
                "arises only in taxation",
                "arises because scarce resources have alternative uses",
                "arises only in monopoly",
                "arises only in banking"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0535",
            question = "Which situation is most consistent with the concept of choice?",
            options = listOf(
                "arises only in taxation",
                "arises because scarce resources have alternative uses",
                "arises only in monopoly",
                "arises only in banking"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0536",
            question = "Which of the following best describes opportunity cost?",
            options = listOf(
                "accounting profit",
                "market price",
                "value of the next best alternative foregone",
                "total money spent"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0537",
            question = "Which situation is most consistent with the concept of opportunity cost?",
            options = listOf(
                "accounting profit",
                "market price",
                "value of the next best alternative foregone",
                "total money spent"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0538",
            question = "Which of the following best describes positive economics?",
            options = listOf(
                "deals only with moral judgements",
                "deals only with law",
                "deals only with accounting",
                "deals with statements that can be examined using facts"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0539",
            question = "Which of the following best describes normative economics?",
            options = listOf(
                "involves value judgements about what ought to be",
                "contains only factual statements",
                "contains only statistics",
                "contains only tax rules"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0540",
            question = "Which of the following best describes microeconomics?",
            options = listOf(
                "studies only population",
                "studies individual consumers, firms and specific markets",
                "studies the whole economy only",
                "studies only politics"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0541",
            question = "Which of the following best describes macroeconomics?",
            options = listOf(
                "studies only one firm",
                "studies only one product",
                "studies economy-wide aggregates",
                "studies only one consumer"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0542",
            question = "Which statement about economics is correct?",
            options = listOf(
                "study of only money",
                "study of only accounting",
                "study of weather",
                "study of allocation of scarce resources among competing uses"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0543",
            question = "Which statement about scarcity is correct?",
            options = listOf(
                "resources are limited relative to human wants",
                "wants are limited",
                "resources are unlimited",
                "prices are always fixed"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0544",
            question = "Which statement about choice is correct?",
            options = listOf(
                "arises only in taxation",
                "arises because scarce resources have alternative uses",
                "arises only in monopoly",
                "arises only in banking"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0545",
            question = "Which statement about opportunity cost is correct?",
            options = listOf(
                "accounting profit",
                "market price",
                "value of the next best alternative foregone",
                "total money spent"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0546",
            question = "Which statement about positive economics is correct?",
            options = listOf(
                "deals only with moral judgements",
                "deals only with law",
                "deals only with accounting",
                "deals with statements that can be examined using facts"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0547",
            question = "Which statement about normative economics is correct?",
            options = listOf(
                "involves value judgements about what ought to be",
                "contains only factual statements",
                "contains only statistics",
                "contains only tax rules"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0548",
            question = "Which statement about microeconomics is correct?",
            options = listOf(
                "studies only population",
                "studies individual consumers, firms and specific markets",
                "studies the whole economy only",
                "studies only politics"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0549",
            question = "Which statement about macroeconomics is correct?",
            options = listOf(
                "studies only one firm",
                "studies only one product",
                "studies economy-wide aggregates",
                "studies only one consumer"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0550",
            question = "Which of the following best describes utility?",
            options = listOf(
                "market price",
                "production cost",
                "tax burden",
                "want-satisfying capacity of a commodity"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0551",
            question = "Which situation is most consistent with the concept of utility?",
            options = listOf(
                "market price",
                "production cost",
                "tax burden",
                "want-satisfying capacity of a commodity"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0552",
            question = "Which of the following best describes total utility?",
            options = listOf(
                "sum of utilities obtained from all units consumed",
                "utility of the last unit only",
                "price times quantity",
                "income minus saving"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0553",
            question = "Which situation is most consistent with the concept of total utility?",
            options = listOf(
                "sum of utilities obtained from all units consumed",
                "utility of the last unit only",
                "price times quantity",
                "income minus saving"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0554",
            question = "Which of the following best describes marginal utility?",
            options = listOf(
                "average cost",
                "change in total utility from one additional unit",
                "total utility divided by income",
                "total expenditure"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0555",
            question = "Which situation is most consistent with the concept of marginal utility?",
            options = listOf(
                "average cost",
                "change in total utility from one additional unit",
                "total utility divided by income",
                "total expenditure"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0556",
            question = "Which of the following best describes diminishing marginal utility?",
            options = listOf(
                "total utility always falls",
                "price always rises",
                "marginal utility generally falls as successive units are consumed, other things constant",
                "marginal utility always rises"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0557",
            question = "Which situation is most consistent with the concept of diminishing marginal utility?",
            options = listOf(
                "total utility always falls",
                "price always rises",
                "marginal utility generally falls as successive units are consumed, other things constant",
                "marginal utility always rises"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0558",
            question = "Which of the following best describes consumer equilibrium?",
            options = listOf(
                "firm maximises output",
                "government balances budget",
                "bank maximises deposits",
                "position where satisfaction is maximum subject to the consumer's budget"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0559",
            question = "Which situation is most consistent with the concept of consumer equilibrium?",
            options = listOf(
                "firm maximises output",
                "government balances budget",
                "bank maximises deposits",
                "position where satisfaction is maximum subject to the consumer's budget"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0560",
            question = "Which of the following best describes budget set?",
            options = listOf(
                "all combinations of goods that a consumer can afford",
                "all goods available in market",
                "only one affordable bundle",
                "all production plans"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0561",
            question = "Which of the following best describes budget line?",
            options = listOf(
                "profit curve",
                "combinations of two goods that exhaust given income at given prices",
                "all unattainable bundles",
                "all goods in the economy"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0562",
            question = "Which of the following best describes normal good?",
            options = listOf(
                "demand never changes",
                "is always a free good",
                "demand generally rises when income rises, ceteris paribus",
                "demand always falls with income"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0563",
            question = "Which of the following best describes inferior good?",
            options = listOf(
                "demand always rises",
                "is always a luxury",
                "is always a complement",
                "demand may fall when income rises, ceteris paribus"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0564",
            question = "Which of the following best describes substitutes?",
            options = listOf(
                "goods that can replace each other",
                "goods used jointly",
                "goods with no utility",
                "free goods"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0565",
            question = "Which of the following best describes complements?",
            options = listOf(
                "inferior goods only",
                "goods generally consumed together",
                "goods that replace each other",
                "unrelated goods"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0566",
            question = "Which of the following best describes price elasticity of demand?",
            options = listOf(
                "change in total utility",
                "change in GDP",
                "responsiveness of quantity demanded to a change in price",
                "responsiveness of supply to income"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0567",
            question = "Which of the following best describes unitary elasticity?",
            options = listOf(
                "quantity never changes",
                "response is infinite",
                "price never changes",
                "percentage change in quantity demanded equals percentage change in price in magnitude"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0568",
            question = "Which of the following best describes law of demand?",
            options = listOf(
                "quantity demanded generally varies inversely with price, other things constant",
                "demand always rises with price",
                "supply falls with price",
                "income is always fixed"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0569",
            question = "Which statement about utility is correct?",
            options = listOf(
                "tax burden",
                "want-satisfying capacity of a commodity",
                "market price",
                "production cost"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0570",
            question = "Which statement about total utility is correct?",
            options = listOf(
                "price times quantity",
                "income minus saving",
                "sum of utilities obtained from all units consumed",
                "utility of the last unit only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0571",
            question = "Which statement about marginal utility is correct?",
            options = listOf(
                "total utility divided by income",
                "total expenditure",
                "average cost",
                "change in total utility from one additional unit"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0572",
            question = "Which statement about diminishing marginal utility is correct?",
            options = listOf(
                "marginal utility generally falls as successive units are consumed, other things constant",
                "marginal utility always rises",
                "total utility always falls",
                "price always rises"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0573",
            question = "Which statement about consumer equilibrium is correct?",
            options = listOf(
                "bank maximises deposits",
                "position where satisfaction is maximum subject to the consumer's budget",
                "firm maximises output",
                "government balances budget"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0574",
            question = "Which statement about budget set is correct?",
            options = listOf(
                "only one affordable bundle",
                "all production plans",
                "all combinations of goods that a consumer can afford",
                "all goods available in market"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0575",
            question = "Which statement about budget line is correct?",
            options = listOf(
                "all unattainable bundles",
                "all goods in the economy",
                "profit curve",
                "combinations of two goods that exhaust given income at given prices"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0576",
            question = "Which statement about normal good is correct?",
            options = listOf(
                "demand generally rises when income rises, ceteris paribus",
                "demand always falls with income",
                "demand never changes",
                "is always a free good"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0577",
            question = "Which statement about inferior good is correct?",
            options = listOf(
                "is always a complement",
                "demand may fall when income rises, ceteris paribus",
                "demand always rises",
                "is always a luxury"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0578",
            question = "Which statement about substitutes is correct?",
            options = listOf(
                "goods with no utility",
                "free goods",
                "goods that can replace each other",
                "goods used jointly"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0579",
            question = "Which statement about complements is correct?",
            options = listOf(
                "goods that replace each other",
                "unrelated goods",
                "inferior goods only",
                "goods generally consumed together"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0580",
            question = "Which statement about price elasticity of demand is correct?",
            options = listOf(
                "responsiveness of quantity demanded to a change in price",
                "responsiveness of supply to income",
                "change in total utility",
                "change in GDP"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0581",
            question = "Which statement about unitary elasticity is correct?",
            options = listOf(
                "price never changes",
                "percentage change in quantity demanded equals percentage change in price in magnitude",
                "quantity never changes",
                "response is infinite"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0582",
            question = "Which statement about law of demand is correct?",
            options = listOf(
                "supply falls with price",
                "income is always fixed",
                "quantity demanded generally varies inversely with price, other things constant",
                "demand always rises with price"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0583",
            question = "Which of the following best describes production function?",
            options = listOf(
                "relationship between price and demand",
                "tax schedule",
                "income distribution",
                "relationship between inputs and maximum output"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0584",
            question = "Which situation is most consistent with the concept of production function?",
            options = listOf(
                "relationship between price and demand",
                "tax schedule",
                "income distribution",
                "relationship between inputs and maximum output"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0585",
            question = "Which of the following best describes short run?",
            options = listOf(
                "period in which at least one factor is fixed",
                "period in which all factors are fixed",
                "period with no production",
                "period with no cost"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0586",
            question = "Which situation is most consistent with the concept of short run?",
            options = listOf(
                "period in which at least one factor is fixed",
                "period in which all factors are fixed",
                "period with no production",
                "period with no cost"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0587",
            question = "Which of the following best describes variable factor?",
            options = listOf(
                "tax",
                "input whose quantity can be changed in the short run",
                "input that can never change",
                "consumer good"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0588",
            question = "Which of the following best describes total product?",
            options = listOf(
                "change in output",
                "total cost",
                "total output produced with given inputs",
                "output per unit input"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0589",
            question = "Which of the following best describes average product?",
            options = listOf(
                "change in output",
                "total fixed cost",
                "total revenue",
                "output per unit of variable input"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0590",
            question = "Which of the following best describes marginal product?",
            options = listOf(
                "change in total product due to one more unit of variable input",
                "total product divided by price",
                "total cost",
                "average revenue"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0591",
            question = "Which of the following best describes law of variable proportions?",
            options = listOf(
                "demand changes",
                "output changes when one factor varies while others remain fixed",
                "all factors change proportionately",
                "prices remain fixed"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0592",
            question = "Which of the following best describes diminishing marginal product?",
            options = listOf(
                "total product immediately falls",
                "fixed cost rises",
                "marginal product eventually decreases as more variable input is used with fixed inputs",
                "marginal product always rises"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0593",
            question = "Which of the following best describes fixed cost?",
            options = listOf(
                "cost that always varies",
                "revenue",
                "profit",
                "cost that does not vary with output in the short run"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0594",
            question = "Which of the following best describes variable cost?",
            options = listOf(
                "cost that varies with output",
                "fixed rent only",
                "share capital",
                "tax reserve"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0595",
            question = "Which of the following best describes total cost?",
            options = listOf(
                "only fixed cost",
                "sum of total fixed cost and total variable cost",
                "difference between revenue and cost",
                "only variable cost"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0596",
            question = "Which of the following best describes average cost?",
            options = listOf(
                "total revenue per unit",
                "fixed cost only",
                "total cost per unit of output",
                "change in total cost"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0597",
            question = "Which of the following best describes marginal cost?",
            options = listOf(
                "total cost divided by output",
                "fixed cost",
                "average revenue",
                "change in total cost due to one additional unit of output"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0598",
            question = "Which of the following best describes returns to scale?",
            options = listOf(
                "response of output to proportional change in all inputs in the long run",
                "response to one input only",
                "change in price",
                "change in demand"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0599",
            question = "Which statement about production function is correct?",
            options = listOf(
                "income distribution",
                "relationship between inputs and maximum output",
                "relationship between price and demand",
                "tax schedule"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0600",
            question = "Which statement about short run is correct?",
            options = listOf(
                "period with no production",
                "period with no cost",
                "period in which at least one factor is fixed",
                "period in which all factors are fixed"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0601",
            question = "Which statement about variable factor is correct?",
            options = listOf(
                "input that can never change",
                "consumer good",
                "tax",
                "input whose quantity can be changed in the short run"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0602",
            question = "Which statement about total product is correct?",
            options = listOf(
                "total output produced with given inputs",
                "output per unit input",
                "change in output",
                "total cost"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0603",
            question = "Which statement about average product is correct?",
            options = listOf(
                "total revenue",
                "output per unit of variable input",
                "change in output",
                "total fixed cost"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0604",
            question = "Which statement about marginal product is correct?",
            options = listOf(
                "total cost",
                "average revenue",
                "change in total product due to one more unit of variable input",
                "total product divided by price"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0605",
            question = "Which statement about law of variable proportions is correct?",
            options = listOf(
                "all factors change proportionately",
                "prices remain fixed",
                "demand changes",
                "output changes when one factor varies while others remain fixed"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0606",
            question = "Which statement about diminishing marginal product is correct?",
            options = listOf(
                "marginal product eventually decreases as more variable input is used with fixed inputs",
                "marginal product always rises",
                "total product immediately falls",
                "fixed cost rises"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0607",
            question = "Which statement about fixed cost is correct?",
            options = listOf(
                "profit",
                "cost that does not vary with output in the short run",
                "cost that always varies",
                "revenue"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0608",
            question = "Which statement about variable cost is correct?",
            options = listOf(
                "share capital",
                "tax reserve",
                "cost that varies with output",
                "fixed rent only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0609",
            question = "Which statement about total cost is correct?",
            options = listOf(
                "difference between revenue and cost",
                "only variable cost",
                "only fixed cost",
                "sum of total fixed cost and total variable cost"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0610",
            question = "Which statement about average cost is correct?",
            options = listOf(
                "total cost per unit of output",
                "change in total cost",
                "total revenue per unit",
                "fixed cost only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0611",
            question = "Which statement about marginal cost is correct?",
            options = listOf(
                "average revenue",
                "change in total cost due to one additional unit of output",
                "total cost divided by output",
                "fixed cost"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0612",
            question = "Which statement about returns to scale is correct?",
            options = listOf(
                "change in price",
                "change in demand",
                "response of output to proportional change in all inputs in the long run",
                "response to one input only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0613",
            question = "Which of the following best describes perfect competition?",
            options = listOf(
                "single seller",
                "differentiated product only",
                "permanent barriers to entry",
                "many buyers and sellers, homogeneous product and free entry/exit"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0614",
            question = "Which situation is most consistent with the concept of perfect competition?",
            options = listOf(
                "permanent barriers to entry",
                "many buyers and sellers, homogeneous product and free entry/exit",
                "single seller",
                "differentiated product only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0615",
            question = "Which of the following best describes price taker?",
            options = listOf(
                "firm accepts the market-determined price",
                "firm fixes market price",
                "government fixes every price",
                "buyer fixes every price"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0616",
            question = "Which situation is most consistent with the concept of price taker?",
            options = listOf(
                "government fixes every price",
                "buyer fixes every price",
                "firm accepts the market-determined price",
                "firm fixes market price"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0617",
            question = "Which of the following best describes homogeneous product?",
            options = listOf(
                "product is complementary",
                "product is identical from the buyer's viewpoint",
                "product is unique",
                "product is branded only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0618",
            question = "Which situation is most consistent with the concept of homogeneous product?",
            options = listOf(
                "product is unique",
                "product is branded only",
                "product is complementary",
                "product is identical from the buyer's viewpoint"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0619",
            question = "Which of the following best describes average revenue?",
            options = listOf(
                "change in revenue",
                "total profit",
                "revenue per unit of output sold",
                "total cost per unit"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0620",
            question = "Which of the following best describes marginal revenue?",
            options = listOf(
                "total revenue per unit",
                "fixed cost",
                "average cost",
                "change in total revenue from one more unit sold"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0621",
            question = "Which of the following best describes profit maximisation?",
            options = listOf(
                "output is chosen where MR equals MC subject to relevant conditions",
                "where AR is zero",
                "where fixed cost is maximum",
                "where output is always zero"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0622",
            question = "Which of the following best describes shutdown point?",
            options = listOf(
                "maximum revenue",
                "short-run point associated with minimum average variable cost",
                "maximum average cost",
                "zero fixed cost"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0623",
            question = "Which of the following best describes break-even point?",
            options = listOf(
                "where fixed cost is zero",
                "where price is zero",
                "point where total revenue equals total cost",
                "where loss is maximum"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0624",
            question = "Which of the following best describes short-run supply?",
            options = listOf(
                "entire demand curve",
                "average cost curve only",
                "total cost curve",
                "portion of MC curve above minimum AVC under perfect competition"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0625",
            question = "Which statement about perfect competition is correct?",
            options = listOf(
                "many buyers and sellers, homogeneous product and free entry/exit",
                "single seller",
                "differentiated product only",
                "permanent barriers to entry"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0626",
            question = "Which statement about price taker is correct?",
            options = listOf(
                "buyer fixes every price",
                "firm accepts the market-determined price",
                "firm fixes market price",
                "government fixes every price"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0627",
            question = "Which statement about homogeneous product is correct?",
            options = listOf(
                "product is branded only",
                "product is complementary",
                "product is identical from the buyer's viewpoint",
                "product is unique"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0628",
            question = "Which statement about average revenue is correct?",
            options = listOf(
                "total cost per unit",
                "change in revenue",
                "total profit",
                "revenue per unit of output sold"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0629",
            question = "Which statement about marginal revenue is correct?",
            options = listOf(
                "change in total revenue from one more unit sold",
                "total revenue per unit",
                "fixed cost",
                "average cost"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0630",
            question = "Which statement about profit maximisation is correct?",
            options = listOf(
                "where output is always zero",
                "output is chosen where MR equals MC subject to relevant conditions",
                "where AR is zero",
                "where fixed cost is maximum"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0631",
            question = "Which statement about shutdown point is correct?",
            options = listOf(
                "zero fixed cost",
                "maximum revenue",
                "short-run point associated with minimum average variable cost",
                "maximum average cost"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0632",
            question = "Which statement about break-even point is correct?",
            options = listOf(
                "where loss is maximum",
                "where fixed cost is zero",
                "where price is zero",
                "point where total revenue equals total cost"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0633",
            question = "Which statement about short-run supply is correct?",
            options = listOf(
                "portion of MC curve above minimum AVC under perfect competition",
                "entire demand curve",
                "average cost curve only",
                "total cost curve"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0634",
            question = "Which of the following best describes market equilibrium?",
            options = listOf(
                "demand is zero",
                "supply is zero",
                "price is always maximum",
                "quantity demanded equals quantity supplied"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0635",
            question = "Which situation is most consistent with the concept of market equilibrium?",
            options = listOf(
                "demand is zero",
                "supply is zero",
                "price is always maximum",
                "quantity demanded equals quantity supplied"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0636",
            question = "Which of the following best describes excess demand?",
            options = listOf(
                "quantity demanded exceeds quantity supplied at a given price",
                "quantity supplied exceeds demand",
                "both are zero",
                "profit exceeds revenue"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0637",
            question = "Which situation is most consistent with the concept of excess demand?",
            options = listOf(
                "quantity demanded exceeds quantity supplied at a given price",
                "quantity supplied exceeds demand",
                "both are zero",
                "profit exceeds revenue"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0638",
            question = "Which of the following best describes excess supply?",
            options = listOf(
                "income exceeds saving",
                "quantity supplied exceeds quantity demanded at a given price",
                "demand exceeds supply",
                "price equals cost"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0639",
            question = "Which situation is most consistent with the concept of excess supply?",
            options = listOf(
                "income exceeds saving",
                "quantity supplied exceeds quantity demanded at a given price",
                "demand exceeds supply",
                "price equals cost"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0640",
            question = "Which of the following best describes price ceiling?",
            options = listOf(
                "market price only",
                "tax rate",
                "legally imposed maximum price",
                "legally imposed minimum price"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0641",
            question = "Which situation is most consistent with the concept of price ceiling?",
            options = listOf(
                "market price only",
                "tax rate",
                "legally imposed maximum price",
                "legally imposed minimum price"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0642",
            question = "Which of the following best describes price floor?",
            options = listOf(
                "maximum price",
                "subsidy only",
                "interest rate",
                "legally imposed minimum price"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0643",
            question = "Which situation is most consistent with the concept of price floor?",
            options = listOf(
                "maximum price",
                "subsidy only",
                "interest rate",
                "legally imposed minimum price"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0644",
            question = "Which of the following best describes equilibrium price?",
            options = listOf(
                "price at which planned demand and supply are equal",
                "always government price",
                "always zero",
                "always maximum"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0645",
            question = "Which situation is most consistent with the concept of equilibrium price?",
            options = listOf(
                "price at which planned demand and supply are equal",
                "always government price",
                "always zero",
                "always maximum"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0646",
            question = "Which of the following best describes shift in demand?",
            options = listOf(
                "change in fixed cost",
                "change in demand due to a determinant other than own price",
                "movement along demand curve",
                "change in supply only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0647",
            question = "Which of the following best describes movement along demand curve?",
            options = listOf(
                "caused by taste change",
                "caused by population change",
                "caused by a change in the good's own price, ceteris paribus",
                "caused by income change"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0648",
            question = "Which statement about market equilibrium is correct?",
            options = listOf(
                "demand is zero",
                "supply is zero",
                "price is always maximum",
                "quantity demanded equals quantity supplied"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0649",
            question = "Which statement about excess demand is correct?",
            options = listOf(
                "quantity demanded exceeds quantity supplied at a given price",
                "quantity supplied exceeds demand",
                "both are zero",
                "profit exceeds revenue"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0650",
            question = "Which statement about excess supply is correct?",
            options = listOf(
                "income exceeds saving",
                "quantity supplied exceeds quantity demanded at a given price",
                "demand exceeds supply",
                "price equals cost"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0651",
            question = "Which statement about price ceiling is correct?",
            options = listOf(
                "market price only",
                "tax rate",
                "legally imposed maximum price",
                "legally imposed minimum price"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0652",
            question = "Which statement about price floor is correct?",
            options = listOf(
                "maximum price",
                "subsidy only",
                "interest rate",
                "legally imposed minimum price"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0653",
            question = "Which statement about equilibrium price is correct?",
            options = listOf(
                "price at which planned demand and supply are equal",
                "always government price",
                "always zero",
                "always maximum"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0654",
            question = "Which statement about shift in demand is correct?",
            options = listOf(
                "change in fixed cost",
                "change in demand due to a determinant other than own price",
                "movement along demand curve",
                "change in supply only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0655",
            question = "Which statement about movement along demand curve is correct?",
            options = listOf(
                "caused by taste change",
                "caused by population change",
                "caused by a change in the good's own price, ceteris paribus",
                "caused by income change"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_micro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0656",
            question = "Which of the following best describes macroeconomics?",
            options = listOf(
                "study of one consumer",
                "study of one firm",
                "study of one product",
                "study of aggregate economic variables"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0657",
            question = "Which situation is most consistent with the concept of macroeconomics?",
            options = listOf(
                "study of one product",
                "study of aggregate economic variables",
                "study of one consumer",
                "study of one firm"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0658",
            question = "Which of the following best describes aggregate demand?",
            options = listOf(
                "total planned expenditure on final goods and services",
                "only household saving",
                "only exports",
                "only taxes"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0659",
            question = "Which situation is most consistent with the concept of aggregate demand?",
            options = listOf(
                "only exports",
                "only taxes",
                "total planned expenditure on final goods and services",
                "only household saving"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0660",
            question = "Which of the following best describes aggregate supply?",
            options = listOf(
                "only money supply",
                "total output supplied in an economy at a given period",
                "only imports",
                "only saving"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0661",
            question = "Which situation is most consistent with the concept of aggregate supply?",
            options = listOf(
                "only imports",
                "only saving",
                "only money supply",
                "total output supplied in an economy at a given period"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0662",
            question = "Which of the following best describes economic fluctuations?",
            options = listOf(
                "only one firm's sales",
                "only tax collection",
                "changes in overall economic activity over time",
                "only price of one good"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0663",
            question = "Which situation is most consistent with the concept of economic fluctuations?",
            options = listOf(
                "changes in overall economic activity over time",
                "only price of one good",
                "only one firm's sales",
                "only tax collection"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0664",
            question = "Which of the following best describes unemployment?",
            options = listOf(
                "retirement only",
                "student status only",
                "self-employment",
                "condition in which willing and able workers cannot find work at prevailing conditions"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0665",
            question = "Which situation is most consistent with the concept of unemployment?",
            options = listOf(
                "self-employment",
                "condition in which willing and able workers cannot find work at prevailing conditions",
                "retirement only",
                "student status only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0666",
            question = "Which of the following best describes full employment?",
            options = listOf(
                "situation where available labour is largely employed except normal frictional unemployment",
                "zero unemployment in every form",
                "no production",
                "only government employment"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0667",
            question = "Which situation is most consistent with the concept of full employment?",
            options = listOf(
                "no production",
                "only government employment",
                "situation where available labour is largely employed except normal frictional unemployment",
                "zero unemployment in every form"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0668",
            question = "Which of the following best describes economic activity?",
            options = listOf(
                "only taxation",
                "production, consumption, investment and related activities",
                "only banking",
                "only exports"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0669",
            question = "Which situation is most consistent with the concept of economic activity?",
            options = listOf(
                "only banking",
                "only exports",
                "only taxation",
                "production, consumption, investment and related activities"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0670",
            question = "Which statement about macroeconomics is correct?",
            options = listOf(
                "study of one firm",
                "study of one product",
                "study of aggregate economic variables",
                "study of one consumer"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0671",
            question = "A learner wants to identify macroeconomics. Which statement should be selected?",
            options = listOf(
                "study of aggregate economic variables",
                "study of one consumer",
                "study of one firm",
                "study of one product"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0672",
            question = "Which statement about aggregate demand is correct?",
            options = listOf(
                "only household saving",
                "only exports",
                "only taxes",
                "total planned expenditure on final goods and services"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0673",
            question = "A learner wants to identify aggregate demand. Which statement should be selected?",
            options = listOf(
                "only taxes",
                "total planned expenditure on final goods and services",
                "only household saving",
                "only exports"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0674",
            question = "Which statement about aggregate supply is correct?",
            options = listOf(
                "total output supplied in an economy at a given period",
                "only imports",
                "only saving",
                "only money supply"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0675",
            question = "A learner wants to identify aggregate supply. Which statement should be selected?",
            options = listOf(
                "only saving",
                "only money supply",
                "total output supplied in an economy at a given period",
                "only imports"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0676",
            question = "Which statement about economic fluctuations is correct?",
            options = listOf(
                "only tax collection",
                "changes in overall economic activity over time",
                "only price of one good",
                "only one firm's sales"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0677",
            question = "Which statement about unemployment is correct?",
            options = listOf(
                "student status only",
                "self-employment",
                "condition in which willing and able workers cannot find work at prevailing conditions",
                "retirement only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0678",
            question = "Which statement about full employment is correct?",
            options = listOf(
                "zero unemployment in every form",
                "no production",
                "only government employment",
                "situation where available labour is largely employed except normal frictional unemployment"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_1_m0679",
            question = "Which statement about economic activity is correct?",
            options = listOf(
                "production, consumption, investment and related activities",
                "only banking",
                "only exports",
                "only taxation"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0680",
            question = "Which of the following best describes GDP?",
            options = listOf(
                "only exports",
                "only government revenue",
                "only intermediate goods",
                "market value of final goods and services produced within domestic territory during a period"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0681",
            question = "Which of the following best describes GNP?",
            options = listOf(
                "GDP plus net factor income from abroad",
                "GDP minus depreciation",
                "GDP plus taxes",
                "GDP plus imports"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0682",
            question = "Which of the following best describes NNP?",
            options = listOf(
                "GDP minus exports",
                "GNP minus depreciation",
                "GNP plus depreciation",
                "GDP plus imports"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0683",
            question = "Which of the following best describes depreciation?",
            options = listOf(
                "tax payment",
                "wage payment",
                "loss in value of fixed capital due to wear, tear or obsolescence",
                "increase in asset value"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0684",
            question = "Which of the following best describes final good?",
            options = listOf(
                "all intermediate goods",
                "raw material always",
                "capital only",
                "good purchased for final use and not for further production"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0685",
            question = "Which of the following best describes intermediate good?",
            options = listOf(
                "good used as an input for further production",
                "always final consumption",
                "only export",
                "only government service"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0686",
            question = "Which of the following best describes value added?",
            options = listOf(
                "imports minus exports",
                "value of output minus intermediate consumption",
                "sales plus wages only",
                "profit minus tax"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0687",
            question = "Which of the following best describes income method?",
            options = listOf(
                "adds only exports",
                "adds only taxes",
                "measures national income by adding factor incomes",
                "adds only sales"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0688",
            question = "Which of the following best describes expenditure method?",
            options = listOf(
                "adds only wages",
                "adds only profits",
                "adds only imports",
                "measures final expenditure on goods and services"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0689",
            question = "Which of the following best describes circular flow?",
            options = listOf(
                "shows movement of income and expenditure among economic sectors",
                "only price changes",
                "only taxation",
                "only exports"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0690",
            question = "Which of the following best describes nominal GDP?",
            options = listOf(
                "real output only",
                "GDP measured at current prices",
                "GDP at constant prices",
                "GDP adjusted for inflation"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0691",
            question = "Which of the following best describes real GDP?",
            options = listOf(
                "only exports",
                "only money supply",
                "GDP measured at constant/base prices to remove price effects",
                "GDP at current prices only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0692",
            question = "Which of the following best describes GDP deflator?",
            options = listOf(
                "unemployment rate",
                "tax ratio",
                "bank reserve ratio",
                "price index relating nominal GDP to real GDP"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0693",
            question = "Which statement about GDP is correct?",
            options = listOf(
                "market value of final goods and services produced within domestic territory during a period",
                "only exports",
                "only government revenue",
                "only intermediate goods"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0694",
            question = "Which statement about GNP is correct?",
            options = listOf(
                "GDP plus imports",
                "GDP plus net factor income from abroad",
                "GDP minus depreciation",
                "GDP plus taxes"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0695",
            question = "Which statement about NNP is correct?",
            options = listOf(
                "GDP plus imports",
                "GDP minus exports",
                "GNP minus depreciation",
                "GNP plus depreciation"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0696",
            question = "Which statement about depreciation is correct?",
            options = listOf(
                "increase in asset value",
                "tax payment",
                "wage payment",
                "loss in value of fixed capital due to wear, tear or obsolescence"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0697",
            question = "Which statement about final good is correct?",
            options = listOf(
                "good purchased for final use and not for further production",
                "all intermediate goods",
                "raw material always",
                "capital only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0698",
            question = "Which statement about intermediate good is correct?",
            options = listOf(
                "only government service",
                "good used as an input for further production",
                "always final consumption",
                "only export"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0699",
            question = "Which statement about value added is correct?",
            options = listOf(
                "profit minus tax",
                "imports minus exports",
                "value of output minus intermediate consumption",
                "sales plus wages only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0700",
            question = "Which statement about income method is correct?",
            options = listOf(
                "adds only sales",
                "adds only exports",
                "adds only taxes",
                "measures national income by adding factor incomes"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0701",
            question = "Which statement about expenditure method is correct?",
            options = listOf(
                "measures final expenditure on goods and services",
                "adds only wages",
                "adds only profits",
                "adds only imports"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0702",
            question = "Which statement about circular flow is correct?",
            options = listOf(
                "only exports",
                "shows movement of income and expenditure among economic sectors",
                "only price changes",
                "only taxation"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0703",
            question = "Which statement about nominal GDP is correct?",
            options = listOf(
                "GDP adjusted for inflation",
                "real output only",
                "GDP measured at current prices",
                "GDP at constant prices"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0704",
            question = "Which statement about real GDP is correct?",
            options = listOf(
                "GDP at current prices only",
                "only exports",
                "only money supply",
                "GDP measured at constant/base prices to remove price effects"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_2_m0705",
            question = "Which statement about GDP deflator is correct?",
            options = listOf(
                "price index relating nominal GDP to real GDP",
                "unemployment rate",
                "tax ratio",
                "bank reserve ratio"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0706",
            question = "Which of the following best describes money?",
            options = listOf(
                "only commodity",
                "only bank loan",
                "only share",
                "generally accepted medium of exchange"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0707",
            question = "Which of the following best describes medium of exchange?",
            options = listOf(
                "facilitates transactions by serving as a commonly accepted payment instrument",
                "measures profit",
                "stores tax",
                "measures output"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0708",
            question = "Which of the following best describes unit of account?",
            options = listOf(
                "acts only as capital",
                "provides a common measure of value",
                "acts only as a loan",
                "acts only as export"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0709",
            question = "Which of the following best describes store of value?",
            options = listOf(
                "works only for tax",
                "works only for wages",
                "allows purchasing power to be transferred over time",
                "supports barter only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0710",
            question = "Which of the following best describes central bank?",
            options = listOf(
                "ordinary retail bank",
                "stock exchange",
                "insurance company",
                "apex monetary authority of the country"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0711",
            question = "Which of the following best describes commercial bank?",
            options = listOf(
                "accepts deposits and provides credit",
                "prints all currency",
                "sets government budget",
                "collects customs"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0712",
            question = "Which of the following best describes CRR?",
            options = listOf(
                "share dividend",
                "portion of deposits banks keep as prescribed cash reserve with the central bank",
                "loan interest rate",
                "tax rate"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0713",
            question = "Which of the following best describes repo rate?",
            options = listOf(
                "wage rate",
                "tax rate",
                "rate at which the central bank lends to banks against eligible securities",
                "consumer price"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0714",
            question = "Which of the following best describes open market operations?",
            options = listOf(
                "setting wages",
                "changing GST only",
                "issuing company shares",
                "central bank purchase or sale of government securities"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0715",
            question = "Which of the following best describes credit creation?",
            options = listOf(
                "process by which banks create deposits through lending subject to reserve requirements",
                "government creates shares",
                "firms print currency",
                "households print notes"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0716",
            question = "Which of the following best describes money multiplier?",
            options = listOf(
                "price index",
                "relationship between reserve ratio and potential deposit expansion in a simplified model",
                "tax multiplier only",
                "profit ratio"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0717",
            question = "Which statement about money is correct?",
            options = listOf(
                "only bank loan",
                "only share",
                "generally accepted medium of exchange",
                "only commodity"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0718",
            question = "Which statement about medium of exchange is correct?",
            options = listOf(
                "measures profit",
                "stores tax",
                "measures output",
                "facilitates transactions by serving as a commonly accepted payment instrument"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0719",
            question = "Which statement about unit of account is correct?",
            options = listOf(
                "provides a common measure of value",
                "acts only as a loan",
                "acts only as export",
                "acts only as capital"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0720",
            question = "Which statement about store of value is correct?",
            options = listOf(
                "works only for wages",
                "allows purchasing power to be transferred over time",
                "supports barter only",
                "works only for tax"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0721",
            question = "Which statement about central bank is correct?",
            options = listOf(
                "stock exchange",
                "insurance company",
                "apex monetary authority of the country",
                "ordinary retail bank"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0722",
            question = "Which statement about commercial bank is correct?",
            options = listOf(
                "prints all currency",
                "sets government budget",
                "collects customs",
                "accepts deposits and provides credit"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0723",
            question = "Which statement about CRR is correct?",
            options = listOf(
                "portion of deposits banks keep as prescribed cash reserve with the central bank",
                "loan interest rate",
                "tax rate",
                "share dividend"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0724",
            question = "Which statement about repo rate is correct?",
            options = listOf(
                "tax rate",
                "rate at which the central bank lends to banks against eligible securities",
                "consumer price",
                "wage rate"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0725",
            question = "Which statement about open market operations is correct?",
            options = listOf(
                "changing GST only",
                "issuing company shares",
                "central bank purchase or sale of government securities",
                "setting wages"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0726",
            question = "Which statement about credit creation is correct?",
            options = listOf(
                "government creates shares",
                "firms print currency",
                "households print notes",
                "process by which banks create deposits through lending subject to reserve requirements"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_3_m0727",
            question = "Which statement about money multiplier is correct?",
            options = listOf(
                "relationship between reserve ratio and potential deposit expansion in a simplified model",
                "tax multiplier only",
                "profit ratio",
                "price index"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0728",
            question = "Which of the following best describes two-sector aggregate demand?",
            options = listOf(
                "consumption plus taxes",
                "exports minus imports",
                "wages only",
                "consumption plus investment"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0729",
            question = "Which situation is most consistent with the concept of two-sector aggregate demand?",
            options = listOf(
                "wages only",
                "consumption plus investment",
                "consumption plus taxes",
                "exports minus imports"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0730",
            question = "Which of the following best describes consumption function?",
            options = listOf(
                "relationship between consumption and income",
                "relationship between price and supply",
                "tax and imports",
                "money and interest only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0731",
            question = "Which situation is most consistent with the concept of consumption function?",
            options = listOf(
                "tax and imports",
                "money and interest only",
                "relationship between consumption and income",
                "relationship between price and supply"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0732",
            question = "Which of the following best describes autonomous consumption?",
            options = listOf(
                "investment only",
                "consumption independent of current income",
                "consumption equal to income",
                "zero consumption"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0733",
            question = "Which situation is most consistent with the concept of autonomous consumption?",
            options = listOf(
                "consumption equal to income",
                "zero consumption",
                "investment only",
                "consumption independent of current income"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0734",
            question = "Which of the following best describes MPC?",
            options = listOf(
                "income divided by consumption",
                "investment divided by income",
                "change in consumption divided by change in income",
                "change in saving divided by price"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0735",
            question = "Which situation is most consistent with the concept of MPC?",
            options = listOf(
                "change in consumption divided by change in income",
                "change in saving divided by price",
                "income divided by consumption",
                "investment divided by income"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0736",
            question = "Which of the following best describes MPS?",
            options = listOf(
                "change in consumption divided by price",
                "saving divided by investment",
                "income divided by saving",
                "change in saving divided by change in income"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0737",
            question = "Which situation is most consistent with the concept of MPS?",
            options = listOf(
                "income divided by saving",
                "change in saving divided by change in income",
                "change in consumption divided by price",
                "saving divided by investment"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0738",
            question = "Which of the following best describes multiplier?",
            options = listOf(
                "ratio of change in equilibrium income to change in autonomous expenditure",
                "ratio of price to demand",
                "tax rate",
                "profit margin"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0739",
            question = "Which situation is most consistent with the concept of multiplier?",
            options = listOf(
                "tax rate",
                "profit margin",
                "ratio of change in equilibrium income to change in autonomous expenditure",
                "ratio of price to demand"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0740",
            question = "Which of the following best describes equilibrium income?",
            options = listOf(
                "where imports are zero",
                "income level at which planned aggregate demand equals output",
                "where saving is always zero",
                "where taxes are maximum"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0741",
            question = "Which situation is most consistent with the concept of equilibrium income?",
            options = listOf(
                "where saving is always zero",
                "where taxes are maximum",
                "where imports are zero",
                "income level at which planned aggregate demand equals output"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0742",
            question = "Which of the following best describes underemployment equilibrium?",
            options = listOf(
                "output is always zero",
                "inflation is always zero",
                "equilibrium can exist below full-employment output",
                "employment is always full"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0743",
            question = "Which situation is most consistent with the concept of underemployment equilibrium?",
            options = listOf(
                "equilibrium can exist below full-employment output",
                "employment is always full",
                "output is always zero",
                "inflation is always zero"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0744",
            question = "Which of the following best describes investment?",
            options = listOf(
                "only consumption",
                "only taxes",
                "only exports",
                "component of aggregate demand representing addition to capital assets"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0745",
            question = "Which situation is most consistent with the concept of investment?",
            options = listOf(
                "only exports",
                "component of aggregate demand representing addition to capital assets",
                "only consumption",
                "only taxes"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0746",
            question = "Which of the following best describes excess demand?",
            options = listOf(
                "planned expenditure exceeds available output at the existing price level",
                "output exceeds spending",
                "saving exceeds investment",
                "imports exceed exports"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0747",
            question = "Which situation is most consistent with the concept of excess demand?",
            options = listOf(
                "saving exceeds investment",
                "imports exceed exports",
                "planned expenditure exceeds available output at the existing price level",
                "output exceeds spending"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0748",
            question = "Which of the following best describes deficient demand?",
            options = listOf(
                "exports exceed imports",
                "planned expenditure is insufficient to sustain full-employment output",
                "demand exceeds output",
                "tax exceeds income"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0749",
            question = "Which statement about two-sector aggregate demand is correct?",
            options = listOf(
                "exports minus imports",
                "wages only",
                "consumption plus investment",
                "consumption plus taxes"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0750",
            question = "Which statement about consumption function is correct?",
            options = listOf(
                "relationship between price and supply",
                "tax and imports",
                "money and interest only",
                "relationship between consumption and income"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0751",
            question = "Which statement about autonomous consumption is correct?",
            options = listOf(
                "consumption independent of current income",
                "consumption equal to income",
                "zero consumption",
                "investment only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0752",
            question = "Which statement about MPC is correct?",
            options = listOf(
                "investment divided by income",
                "change in consumption divided by change in income",
                "change in saving divided by price",
                "income divided by consumption"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0753",
            question = "Which statement about MPS is correct?",
            options = listOf(
                "saving divided by investment",
                "income divided by saving",
                "change in saving divided by change in income",
                "change in consumption divided by price"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0754",
            question = "Which statement about multiplier is correct?",
            options = listOf(
                "ratio of price to demand",
                "tax rate",
                "profit margin",
                "ratio of change in equilibrium income to change in autonomous expenditure"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0755",
            question = "Which statement about equilibrium income is correct?",
            options = listOf(
                "income level at which planned aggregate demand equals output",
                "where saving is always zero",
                "where taxes are maximum",
                "where imports are zero"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0756",
            question = "Which statement about underemployment equilibrium is correct?",
            options = listOf(
                "inflation is always zero",
                "equilibrium can exist below full-employment output",
                "employment is always full",
                "output is always zero"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0757",
            question = "Which statement about investment is correct?",
            options = listOf(
                "only taxes",
                "only exports",
                "component of aggregate demand representing addition to capital assets",
                "only consumption"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0758",
            question = "Which statement about excess demand is correct?",
            options = listOf(
                "output exceeds spending",
                "saving exceeds investment",
                "imports exceed exports",
                "planned expenditure exceeds available output at the existing price level"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_4_m0759",
            question = "Which statement about deficient demand is correct?",
            options = listOf(
                "planned expenditure is insufficient to sustain full-employment output",
                "demand exceeds output",
                "tax exceeds income",
                "exports exceed imports"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0760",
            question = "Which of the following best describes government budget?",
            options = listOf(
                "private firm's balance sheet",
                "bank ledger",
                "trade invoice",
                "annual statement of estimated government receipts and expenditure"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0761",
            question = "Which of the following best describes revenue receipt?",
            options = listOf(
                "receipt that normally neither creates liability nor reduces assets",
                "borrowing",
                "sale of asset",
                "recovery of loan"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0762",
            question = "Which of the following best describes capital receipt?",
            options = listOf(
                "fine",
                "receipt that creates liability or reduces assets",
                "tax revenue",
                "fee"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0763",
            question = "Which of the following best describes revenue expenditure?",
            options = listOf(
                "loan repayment",
                "purchase of land",
                "expenditure that normally does not create assets or reduce liabilities",
                "purchase of machinery"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0764",
            question = "Which of the following best describes fiscal deficit?",
            options = listOf(
                "revenue receipts minus tax",
                "exports minus imports",
                "profit minus cost",
                "excess of total expenditure over total receipts excluding borrowings"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0765",
            question = "Which of the following best describes revenue deficit?",
            options = listOf(
                "excess of revenue expenditure over revenue receipts",
                "capital expenditure minus receipts",
                "imports minus exports",
                "profit minus tax"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0766",
            question = "Which of the following best describes primary deficit?",
            options = listOf(
                "GDP minus depreciation",
                "fiscal deficit minus interest payments",
                "revenue deficit plus interest",
                "tax minus expenditure"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0767",
            question = "Which of the following best describes balanced budget?",
            options = listOf(
                "receipts always exceed expenditure",
                "no taxation",
                "estimated receipts equal estimated expenditure",
                "expenditure always exceeds receipts"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0768",
            question = "Which of the following best describes surplus budget?",
            options = listOf(
                "expenditure exceeds receipts",
                "receipts equal expenditure",
                "borrowing is always zero",
                "receipts exceed expenditure"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0769",
            question = "Which of the following best describes deficit budget?",
            options = listOf(
                "expenditure exceeds receipts",
                "receipts exceed expenditure",
                "government spending is zero",
                "taxation is zero"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0770",
            question = "Which of the following best describes redistribution objective?",
            options = listOf(
                "only measure GDP",
                "budget can reduce inequality through taxation and public expenditure",
                "only increase imports",
                "only control banks"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0771",
            question = "Which statement about government budget is correct?",
            options = listOf(
                "bank ledger",
                "trade invoice",
                "annual statement of estimated government receipts and expenditure",
                "private firm's balance sheet"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0772",
            question = "Which statement about revenue receipt is correct?",
            options = listOf(
                "borrowing",
                "sale of asset",
                "recovery of loan",
                "receipt that normally neither creates liability nor reduces assets"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0773",
            question = "Which statement about capital receipt is correct?",
            options = listOf(
                "receipt that creates liability or reduces assets",
                "tax revenue",
                "fee",
                "fine"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0774",
            question = "Which statement about revenue expenditure is correct?",
            options = listOf(
                "purchase of land",
                "expenditure that normally does not create assets or reduce liabilities",
                "purchase of machinery",
                "loan repayment"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0775",
            question = "Which statement about fiscal deficit is correct?",
            options = listOf(
                "exports minus imports",
                "profit minus cost",
                "excess of total expenditure over total receipts excluding borrowings",
                "revenue receipts minus tax"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0776",
            question = "Which statement about revenue deficit is correct?",
            options = listOf(
                "capital expenditure minus receipts",
                "imports minus exports",
                "profit minus tax",
                "excess of revenue expenditure over revenue receipts"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0777",
            question = "Which statement about primary deficit is correct?",
            options = listOf(
                "fiscal deficit minus interest payments",
                "revenue deficit plus interest",
                "tax minus expenditure",
                "GDP minus depreciation"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0778",
            question = "Which statement about balanced budget is correct?",
            options = listOf(
                "no taxation",
                "estimated receipts equal estimated expenditure",
                "expenditure always exceeds receipts",
                "receipts always exceed expenditure"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0779",
            question = "Which statement about surplus budget is correct?",
            options = listOf(
                "receipts equal expenditure",
                "borrowing is always zero",
                "receipts exceed expenditure",
                "expenditure exceeds receipts"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0780",
            question = "Which statement about deficit budget is correct?",
            options = listOf(
                "receipts exceed expenditure",
                "government spending is zero",
                "taxation is zero",
                "expenditure exceeds receipts"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_5_m0781",
            question = "Which statement about redistribution objective is correct?",
            options = listOf(
                "budget can reduce inequality through taxation and public expenditure",
                "only increase imports",
                "only control banks",
                "only measure GDP"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0782",
            question = "Which of the following best describes balance of payments?",
            options = listOf(
                "only exports",
                "only imports",
                "only tax",
                "systematic record of economic transactions between residents and the rest of the world"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0783",
            question = "Which situation is most consistent with the concept of balance of payments?",
            options = listOf(
                "only exports",
                "only imports",
                "only tax",
                "systematic record of economic transactions between residents and the rest of the world"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0784",
            question = "Which of the following best describes current account?",
            options = listOf(
                "records trade in goods and services, income and transfers",
                "only capital flows",
                "only bank reserves",
                "only share issues"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0785",
            question = "Which of the following best describes capital/financial account?",
            options = listOf(
                "only taxes",
                "records specified capital and financial transactions",
                "only merchandise exports",
                "only consumption"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0786",
            question = "Which of the following best describes exchange rate?",
            options = listOf(
                "tax rate",
                "wage rate",
                "price of one currency in terms of another",
                "interest rate only"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0787",
            question = "Which of the following best describes appreciation?",
            options = listOf(
                "fall in value",
                "increase in inflation only",
                "increase in GDP",
                "rise in the external value of a currency under a flexible exchange system"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0788",
            question = "Which of the following best describes depreciation?",
            options = listOf(
                "fall in the external value of a currency under a flexible exchange system",
                "rise in value",
                "increase in tax",
                "fall in imports always"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0789",
            question = "Which of the following best describes foreign exchange market?",
            options = listOf(
                "market for land",
                "market in which currencies are exchanged",
                "market for shares only",
                "market for labour"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0790",
            question = "Which of the following best describes fixed exchange rate?",
            options = listOf(
                "rate never managed",
                "barter system",
                "exchange rate maintained by monetary authority under a policy arrangement",
                "rate determined only by demand"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0791",
            question = "Which of the following best describes managed floating?",
            options = listOf(
                "permanent fixed rate",
                "no foreign exchange market",
                "barter system",
                "exchange rate mainly market-determined with occasional official intervention"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0792",
            question = "Which of the following best describes trade balance?",
            options = listOf(
                "difference between exports and imports of goods",
                "difference between GDP and GNP",
                "difference between saving and investment",
                "difference between tax and spending"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0793",
            question = "Which statement about balance of payments is correct?",
            options = listOf(
                "only tax",
                "systematic record of economic transactions between residents and the rest of the world",
                "only exports",
                "only imports"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0794",
            question = "Which statement about current account is correct?",
            options = listOf(
                "only bank reserves",
                "only share issues",
                "records trade in goods and services, income and transfers",
                "only capital flows"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0795",
            question = "Which statement about capital/financial account is correct?",
            options = listOf(
                "only merchandise exports",
                "only consumption",
                "only taxes",
                "records specified capital and financial transactions"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0796",
            question = "Which statement about exchange rate is correct?",
            options = listOf(
                "price of one currency in terms of another",
                "interest rate only",
                "tax rate",
                "wage rate"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0797",
            question = "Which statement about appreciation is correct?",
            options = listOf(
                "increase in GDP",
                "rise in the external value of a currency under a flexible exchange system",
                "fall in value",
                "increase in inflation only"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0798",
            question = "Which statement about depreciation is correct?",
            options = listOf(
                "increase in tax",
                "fall in imports always",
                "fall in the external value of a currency under a flexible exchange system",
                "rise in value"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0799",
            question = "Which statement about foreign exchange market is correct?",
            options = listOf(
                "market for shares only",
                "market for labour",
                "market for land",
                "market in which currencies are exchanged"
            ),
            correctAnswer = 1,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0800",
            question = "Which statement about fixed exchange rate is correct?",
            options = listOf(
                "exchange rate maintained by monetary authority under a policy arrangement",
                "rate determined only by demand",
                "rate never managed",
                "barter system"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0801",
            question = "Which statement about managed floating is correct?",
            options = listOf(
                "barter system",
                "exchange rate mainly market-determined with occasional official intervention",
                "permanent fixed rate",
                "no foreign exchange market"
            ),
            correctAnswer = 3,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "economics_class_12_6_m0802",
            question = "Which statement about trade balance is correct?",
            options = listOf(
                "difference between saving and investment",
                "difference between tax and spending",
                "difference between exports and imports of goods",
                "difference between GDP and GNP"
            ),
            correctAnswer = 2,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "economics",
            chapterId = "economics_class_12_macro_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0803",
            question = "कबीर की भाषा को सामान्यतः किस रूप में जाना जाता है?",
            options = listOf(
                "सधुक्कड़ी",
                "ब्रजभाषा",
                "अवधी",
                "मैथिली"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0804",
            question = "कबीर का जन्मस्थान परंपरागत रूप से किस नगर को माना जाता है?",
            options = listOf(
                "काशी",
                "उज्जैन",
                "मथुरा",
                "पटना"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0805",
            question = "कबीर की मृत्यु के लिए प्रसिद्ध स्थान कौन-सा है?",
            options = listOf(
                "मगहर",
                "चित्रकूट",
                "अयोध्या",
                "वाराणसी"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0806",
            question = "कबीर के काव्य में प्रमुख रूप से किसका विरोध मिलता है?",
            options = listOf(
                "आडंबर और पाखंड",
                "प्रकृति-वर्णन",
                "राजदरबार",
                "युद्ध-वर्णन"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0807",
            question = "कबीर की वाणी का प्रमुख उद्देश्य क्या है?",
            options = listOf(
                "आत्मबोध और सामाजिक जागरण",
                "मनोरंजन",
                "राजप्रशंसा",
                "युद्धकथा"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0808",
            question = "तुलसीदास का जन्मस्थान सामान्यतः किसे माना जाता है?",
            options = listOf(
                "राजापुर",
                "मगहर",
                "इलाहाबाद",
                "उज्जैन"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0809",
            question = "तुलसीदास की प्रमुख कृति कौन-सी है?",
            options = listOf(
                "रामचरितमानस",
                "कामायनी",
                "साकेत",
                "यामा"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0810",
            question = "रामचरितमानस की भाषा मुख्यतः क्या है?",
            options = listOf(
                "अवधी",
                "ब्रज",
                "खड़ी बोली",
                "मैथिली"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0811",
            question = "तुलसीदास की भक्ति किस भाव से विशेष रूप से जुड़ी है?",
            options = listOf(
                "रामभक्ति",
                "कृष्णभक्ति",
                "शक्तिभक्ति",
                "सूफी प्रेम"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0812",
            question = "तुलसीदास का निधन सामान्यतः किस वर्ष माना जाता है?",
            options = listOf(
                "1623 ई.",
                "1498 ई.",
                "1857 ई.",
                "1707 ई."
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0813",
            question = "सूरदास की भक्ति का प्रमुख केंद्र कौन हैं?",
            options = listOf(
                "श्रीकृष्ण",
                "शिव",
                "राम",
                "बुद्ध"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0814",
            question = "सूरदास की प्रमुख कृति कौन-सी मानी जाती है?",
            options = listOf(
                "सूरसागर",
                "साकेत",
                "यामा",
                "उर्वशी"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0815",
            question = "सूरदास की भाषा मुख्यतः क्या है?",
            options = listOf(
                "ब्रजभाषा",
                "अवधी",
                "मैथिली",
                "राजस्थानी"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0816",
            question = "सूरदास का संबंध किस भक्ति धारा से है?",
            options = listOf(
                "सगुण कृष्णभक्ति",
                "निर्गुण भक्ति",
                "सूफी भक्ति",
                "शैव भक्ति"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0817",
            question = "सूरदास की काव्य-दृष्टि में कौन-सा रस प्रमुख है?",
            options = listOf(
                "वात्सल्य",
                "भयानक",
                "वीभत्स",
                "अद्भुत"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0818",
            question = "महादेवी वर्मा को हिंदी साहित्य में किस काव्यधारा से जोड़ा जाता है?",
            options = listOf(
                "छायावाद",
                "रीतिकाल",
                "वीरगाथा काल",
                "प्रगतिवाद"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0819",
            question = "महादेवी वर्मा की प्रसिद्ध कृति कौन-सी है?",
            options = listOf(
                "यामा",
                "गोदान",
                "कामायनी",
                "रश्मिरथी"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0820",
            question = "महादेवी वर्मा का जन्म किस वर्ष हुआ था?",
            options = listOf(
                "1907",
                "1885",
                "1920",
                "1899"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0821",
            question = "महादेवी वर्मा का निधन किस वर्ष हुआ?",
            options = listOf(
                "1987",
                "1975",
                "1995",
                "1968"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0822",
            question = "महादेवी वर्मा के काव्य में कौन-सा भाव प्रमुख है?",
            options = listOf(
                "वेदना और करुणा",
                "हास्य",
                "वीरता",
                "व्यंग्य"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0823",
            question = "प्रेमचंद का वास्तविक नाम क्या था?",
            options = listOf(
                "धनपत राय",
                "हरिवंश राय",
                "सच्चिदानंद",
                "रामधारी सिंह"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0824",
            question = "प्रेमचंद का जन्म किस वर्ष हुआ था?",
            options = listOf(
                "1880",
                "1907",
                "1899",
                "1875"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0825",
            question = "प्रेमचंद का निधन किस वर्ष हुआ?",
            options = listOf(
                "1936",
                "1947",
                "1920",
                "1950"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0826",
            question = "गोदान के लेखक कौन हैं?",
            options = listOf(
                "प्रेमचंद",
                "निराला",
                "दिनकर",
                "अज्ञेय"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0827",
            question = "प्रेमचंद के साहित्य की प्रमुख विशेषता क्या है?",
            options = listOf(
                "सामाजिक यथार्थ",
                "दरबारी श्रृंगार",
                "पौराणिक कल्पना मात्र",
                "रहस्यवाद"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0828",
            question = "‘राम ने फल खाया।’ वाक्य में ‘ने’ किस कारक का चिह्न है?",
            options = listOf(
                "कर्ता",
                "कर्म",
                "करण",
                "अपादान"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0829",
            question = "‘मोहन को बुलाओ।’ में ‘को’ कौन-सा कारक है?",
            options = listOf(
                "कर्म",
                "कर्ता",
                "करण",
                "संबंध"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0830",
            question = "‘सुंदर फूल’ में ‘सुंदर’ क्या है?",
            options = listOf(
                "विशेषण",
                "सर्वनाम",
                "क्रिया",
                "समुच्चयबोधक"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0831",
            question = "‘वह स्वयं गया।’ में ‘स्वयं’ कौन-सा सर्वनाम है?",
            options = listOf(
                "निजवाचक",
                "प्रश्नवाचक",
                "अनिश्चयवाचक",
                "संबंधवाचक"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0832",
            question = "‘यदि वर्षा होगी तो फसल अच्छी होगी।’ किस प्रकार का वाक्य है?",
            options = listOf(
                "मिश्र",
                "सरल",
                "संयुक्त",
                "विस्मयादिबोधक"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0833",
            question = "‘विद्यालय’ का संधि-विच्छेद क्या है?",
            options = listOf(
                "विद्या + आलय",
                "विद्य + आलय",
                "वि + द्यालय",
                "विद्या + लय"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0834",
            question = "‘राजपुत्र’ में कौन-सा समास है?",
            options = listOf(
                "तत्पुरुष",
                "द्वंद्व",
                "बहुव्रीहि",
                "अव्ययीभाव"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0835",
            question = "‘नीलकंठ’ किस समास का उदाहरण है?",
            options = listOf(
                "बहुव्रीहि",
                "द्विगु",
                "द्वंद्व",
                "अव्ययीभाव"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0836",
            question = "‘अति + सुंदर’ में कौन-सी संधि मानी जाती है?",
            options = listOf(
                "स्वर संधि",
                "व्यंजन संधि",
                "विसर्ग संधि",
                "कोई नहीं"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0837",
            question = "‘दिन-रात’ किस समास का उदाहरण है?",
            options = listOf(
                "द्वंद्व",
                "तत्पुरुष",
                "बहुव्रीहि",
                "कर्मधारय"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0838",
            question = "‘आँखों का तारा’ मुहावरे का अर्थ है:",
            options = listOf(
                "बहुत प्रिय",
                "बहुत क्रोधित",
                "बहुत गरीब",
                "बहुत दूर"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0839",
            question = "‘नौ दो ग्यारह होना’ का अर्थ है:",
            options = listOf(
                "भाग जाना",
                "जीत जाना",
                "सो जाना",
                "बीमार होना"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0840",
            question = "‘अंधे के हाथ बटेर लगना’ का अर्थ है:",
            options = listOf(
                "अचानक लाभ होना",
                "बहुत मेहनत करना",
                "असफल होना",
                "झगड़ा करना"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0841",
            question = "‘नाक कटना’ का अर्थ है:",
            options = listOf(
                "अपमान होना",
                "बीमार होना",
                "तेज दौड़ना",
                "गुस्सा करना"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0842",
            question = "‘दाँत खट्टे करना’ का अर्थ है:",
            options = listOf(
                "बुरी तरह परास्त करना",
                "भोजन करना",
                "मित्रता करना",
                "मजाक करना"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0843",
            question = "औपचारिक पत्र में विषय कहाँ लिखा जाता है?",
            options = listOf(
                "सम्बोधन के बाद और मुख्य विषय से पहले",
                "हस्ताक्षर के बाद",
                "पते से पहले",
                "केवल अंत में"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0844",
            question = "रिपोर्ट लेखन का प्रमुख गुण क्या है?",
            options = listOf(
                "तथ्यात्मकता और क्रमबद्धता",
                "अत्यधिक कल्पना",
                "केवल संवाद",
                "अलंकारों की अधिकता"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0845",
            question = "विज्ञापन का मुख्य उद्देश्य क्या है?",
            options = listOf(
                "सूचना देकर आकर्षित करना",
                "केवल कहानी सुनाना",
                "केवल आलोचना करना",
                "केवल मनोरंजन"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0846",
            question = "समाचार लेखन में शीर्षक कैसा होना चाहिए?",
            options = listOf(
                "संक्षिप्त और आकर्षक",
                "बहुत लंबा",
                "अस्पष्ट",
                "केवल प्रश्नात्मक"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "hindi_class_12_new_0847",
            question = "संपादकीय मुख्यतः किस प्रकार का लेख होता है?",
            options = listOf(
                "विचारप्रधान",
                "केवल संवादप्रधान",
                "केवल कथा",
                "केवल कविता"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "hindi",
            chapterId = "hindi_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0848",
            question = "Who wrote “The Last Lesson”?",
            options = listOf(
                "Alphonse Daudet",
                "John Keats",
                "Stephen Spender",
                "Anees Jung"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0849",
            question = "M. Hamel was a teacher of:",
            options = listOf(
                "French",
                "English",
                "History",
                "Science"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0850",
            question = "Franz regretted not learning:",
            options = listOf(
                "French",
                "Mathematics",
                "Latin",
                "German"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0851",
            question = "The central theme of “The Last Lesson” is:",
            options = listOf(
                "love for language and freedom",
                "adventure",
                "sports",
                "science"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0852",
            question = "Choose the correct passive form: “They completed the work.”",
            options = listOf(
                "The work was completed by them.",
                "The work is completed by them.",
                "The work has completed them.",
                "The work completed by them."
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0853",
            question = "Choose the correct reported speech: He said, “I am tired.”",
            options = listOf(
                "He said that he was tired.",
                "He says he is tired.",
                "He said that I am tired.",
                "He said that he is tiring."
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0854",
            question = "Choose the correct article: He is ___ honest man.",
            options = listOf(
                "an",
                "a",
                "the",
                "no article"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0855",
            question = "Choose the correct preposition: She is good ___ mathematics.",
            options = listOf(
                "at",
                "in",
                "on",
                "for"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0856",
            question = "Identify the adjective: “She wore a beautiful dress.”",
            options = listOf(
                "beautiful",
                "wore",
                "dress",
                "she"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0857",
            question = "Who wrote “Lost Spring”?",
            options = listOf(
                "Anees Jung",
                "Daudet",
                "Douglas",
                "Bama"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0858",
            question = "Saheb worked at a:",
            options = listOf(
                "tea stall",
                "school",
                "factory office",
                "farm"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0859",
            question = "Mukesh wanted to become a:",
            options = listOf(
                "motor mechanic",
                "teacher",
                "pilot",
                "doctor"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0860",
            question = "“Lost Spring” mainly highlights:",
            options = listOf(
                "poverty and child labour",
                "war",
                "space travel",
                "royal life"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0861",
            question = "Choose the correct tense: “She ___ here since 2020.”",
            options = listOf(
                "has lived",
                "lived",
                "is living",
                "will live"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0862",
            question = "Choose the correct modal: You ___ obey traffic rules.",
            options = listOf(
                "must",
                "might",
                "would",
                "could"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0863",
            question = "Choose the correct conjunction: Work hard ___ you will succeed.",
            options = listOf(
                "and",
                "but",
                "although",
                "because"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0864",
            question = "Identify the adverb: “He spoke politely.”",
            options = listOf(
                "politely",
                "spoke",
                "he",
                "none"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0865",
            question = "Choose the correct question tag: You are coming, ___?",
            options = listOf(
                "aren’t you",
                "are you",
                "isn’t it",
                "don’t you"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0866",
            question = "Who wrote “Deep Water”?",
            options = listOf(
                "William Douglas",
                "Anees Jung",
                "John Keats",
                "Pablo Neruda"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0867",
            question = "Douglas developed fear of:",
            options = listOf(
                "water",
                "heights",
                "darkness",
                "fire"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0868",
            question = "Douglas overcame his fear through:",
            options = listOf(
                "training and practice",
                "ignoring it",
                "sleep",
                "travel"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0869",
            question = "The chapter teaches that fear can be overcome by:",
            options = listOf(
                "persistent effort",
                "avoidance",
                "luck",
                "anger"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0870",
            question = "A notice should be:",
            options = listOf(
                "brief and informative",
                "a long essay",
                "a poem",
                "a story"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0871",
            question = "A formal invitation should use:",
            options = listOf(
                "formal and polite language",
                "slang",
                "text abbreviations",
                "casual jokes"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0872",
            question = "A report should primarily contain:",
            options = listOf(
                "facts and organised information",
                "imaginary events only",
                "dialogues only",
                "poetry"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0873",
            question = "The headline of a report should be:",
            options = listOf(
                "clear and relevant",
                "very long",
                "unrelated",
                "hidden"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0874",
            question = "A letter to the editor generally discusses:",
            options = listOf(
                "a public issue",
                "personal shopping",
                "a private diary",
                "a recipe only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0875",
            question = "Who wrote “The Rattrap”?",
            options = listOf(
                "Selma Lagerlöf",
                "John Keats",
                "Robert Frost",
                "Daudet"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0876",
            question = "The peddler sold:",
            options = listOf(
                "rattraps",
                "books",
                "flowers",
                "toys"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0877",
            question = "The peddler’s view of the world was compared to:",
            options = listOf(
                "a rattrap",
                "a garden",
                "a river",
                "a school"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0878",
            question = "The turning point in the peddler’s life came through:",
            options = listOf(
                "kindness and trust",
                "punishment",
                "wealth",
                "fear"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0879",
            question = "Who wrote “Aunt Jennifer’s Tigers”?",
            options = listOf(
                "Adrienne Rich",
                "John Keats",
                "Pablo Neruda",
                "Robert Frost"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0880",
            question = "Who wrote “Keeping Quiet”?",
            options = listOf(
                "Pablo Neruda",
                "Adrienne Rich",
                "Kamala Das",
                "John Keats"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0881",
            question = "“My Mother at Sixty-Six” was written by:",
            options = listOf(
                "Kamala Das",
                "Adrienne Rich",
                "Carolyn Wells",
                "Anees Jung"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0882",
            question = "“A Thing of Beauty” was written by:",
            options = listOf(
                "John Keats",
                "Robert Frost",
                "Pablo Neruda",
                "Stephen Spender"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0883",
            question = "“Keeping Quiet” emphasizes:",
            options = listOf(
                "peace and introspection",
                "war",
                "competition",
                "wealth"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0884",
            question = "Who wrote “Indigo”?",
            options = listOf(
                "Louis Fischer",
                "Anees Jung",
                "Bama",
                "Katherine Mansfield"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0885",
            question = "Indigo deals with farmers of:",
            options = listOf(
                "Champaran",
                "Bihar city",
                "Delhi",
                "Punjab"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0886",
            question = "Gandhi’s method in Champaran emphasized:",
            options = listOf(
                "non-violent action and truth",
                "war",
                "boycott of education",
                "trade"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0887",
            question = "The chapter presents Gandhi mainly as a:",
            options = listOf(
                "leader of peaceful social action",
                "businessman",
                "scientist",
                "poet"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0888",
            question = "“The Third Level” was written by:",
            options = listOf(
                "Jack Finney",
                "Pearl S. Buck",
                "John Updike",
                "Bama"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0889",
            question = "Charley believed he had found:",
            options = listOf(
                "a third level at Grand Central",
                "a hidden school",
                "a new city",
                "a treasure"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0890",
            question = "“The Enemy” was written by:",
            options = listOf(
                "Pearl S. Buck",
                "Jack Finney",
                "Daudet",
                "Fischer"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0891",
            question = "Dr Sadao’s dilemma in “The Enemy” is between:",
            options = listOf(
                "professional duty and wartime loyalty",
                "money and fame",
                "study and sports",
                "travel and home"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "english_class_12_new_0892",
            question = "“On the Face of It” explores:",
            options = listOf(
                "human connection and acceptance",
                "business",
                "war strategy",
                "politics"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "english",
            chapterId = "english_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0893",
            question = "If f(x)=x², then f is:",
            options = listOf(
                "not one-one on R",
                "one-one on R",
                "onto R",
                "constant"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0894",
            question = "The domain of sin⁻¹x is:",
            options = listOf(
                "[-1,1]",
                "R",
                "[0,∞)",
                "(-∞,0]"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0895",
            question = "For a relation to be an equivalence relation it must be:",
            options = listOf(
                "reflexive, symmetric and transitive",
                "only symmetric",
                "only transitive",
                "only reflexive"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0896",
            question = "If f is invertible, then f⁻¹∘f equals:",
            options = listOf(
                "identity function",
                "zero function",
                "constant function",
                "f²"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0897",
            question = "The principal value range of sin⁻¹x is:",
            options = listOf(
                "[-π/2,π/2]",
                "[0,π]",
                "[-π,π]",
                "[0,2π]"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0898",
            question = "tan⁻¹x + cot⁻¹x equals:",
            options = listOf(
                "π/2",
                "π",
                "0",
                "2π"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0899",
            question = "cos⁻¹x is defined for x in:",
            options = listOf(
                "[-1,1]",
                "R",
                "[0,∞)",
                "(-∞,0]"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0900",
            question = "The derivative of sin⁻¹x is:",
            options = listOf(
                "1/√(1-x²)",
                "1/(1+x²)",
                "-1/√(1-x²)",
                "√(1-x²)"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0901",
            question = "The order of a matrix with 3 rows and 2 columns is:",
            options = listOf(
                "3×2",
                "2×3",
                "3×3",
                "2×2"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0902",
            question = "The determinant of [[a,b],[c,d]] is:",
            options = listOf(
                "ad-bc",
                "ac-bd",
                "ab-cd",
                "ad+bc"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0903",
            question = "A square matrix is singular when its determinant is:",
            options = listOf(
                "0",
                "1",
                "-1",
                "2"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0904",
            question = "If A is 2×2 and |A|=5, then |2A| equals:",
            options = listOf(
                "20",
                "10",
                "5",
                "25"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0905",
            question = "The determinant of an identity matrix is:",
            options = listOf(
                "1",
                "0",
                "2",
                "-1"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0906",
            question = "If A is invertible, then AA⁻¹ equals:",
            options = listOf(
                "I",
                "0",
                "A",
                "A²"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0907",
            question = "The inverse of a matrix exists when its determinant is:",
            options = listOf(
                "non-zero",
                "zero",
                "negative only",
                "one only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0908",
            question = "For a 3×3 matrix, det(kA) equals:",
            options = listOf(
                "k³det(A)",
                "kdet(A)",
                "k²det(A)",
                "det(A)/k"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0909",
            question = "A function is continuous at x=a if:",
            options = listOf(
                "lim x→a f(x)=f(a)",
                "f(a)=0",
                "derivative is zero",
                "f is constant"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0910",
            question = "The derivative of xⁿ is:",
            options = listOf(
                "nxⁿ⁻¹",
                "xⁿ⁺¹/(n+1)",
                "n+x",
                "xⁿ"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0911",
            question = "The derivative of eˣ is:",
            options = listOf(
                "eˣ",
                "xeˣ",
                "1/eˣ",
                "0"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0912",
            question = "If f is differentiable at a, then f is necessarily:",
            options = listOf(
                "continuous at a",
                "discontinuous at a",
                "constant",
                "periodic"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0913",
            question = "The derivative of x³ is:",
            options = listOf(
                "3x²",
                "x²",
                "3x",
                "x³"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0914",
            question = "The derivative of sin x is:",
            options = listOf(
                "cos x",
                "-cos x",
                "sin x",
                "-sin x"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0915",
            question = "The derivative of ln x is:",
            options = listOf(
                "1/x",
                "x",
                "ln x",
                "eˣ"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0916",
            question = "At a local maximum, if f′(a)=0, then generally f″(a) is:",
            options = listOf(
                "negative",
                "positive",
                "zero always",
                "undefined always"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0917",
            question = "∫xⁿ dx for n≠-1 equals:",
            options = listOf(
                "xⁿ⁺¹/(n+1)+C",
                "nxⁿ⁻¹+C",
                "xⁿ/n+C",
                "ln x+C"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0918",
            question = "∫cos x dx equals:",
            options = listOf(
                "sin x+C",
                "-sin x+C",
                "cos x+C",
                "tan x+C"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0919",
            question = "∫1/x dx equals:",
            options = listOf(
                "ln|x|+C",
                "1/x²+C",
                "x+C",
                "eˣ+C"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0920",
            question = "∫eˣ dx equals:",
            options = listOf(
                "eˣ+C",
                "xeˣ+C",
                "ln x+C",
                "1/eˣ+C"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0921",
            question = "The area under y=f(x) from a to b is represented by:",
            options = listOf(
                "∫ₐᵇ f(x)dx",
                "f(b)-f(a)",
                "f(a)+f(b)",
                "∫f′(x)dx only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0922",
            question = "The area between two curves is found using:",
            options = listOf(
                "integral of upper-lower function",
                "sum of slopes",
                "product of derivatives",
                "determinant"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0923",
            question = "If f(x)≥0 on [a,b], then ∫ₐᵇf(x)dx represents:",
            options = listOf(
                "area under curve",
                "slope",
                "maximum value",
                "minimum value"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0924",
            question = "Area enclosed by curves may require splitting the interval when:",
            options = listOf(
                "upper/lower curves change",
                "both are constants",
                "derivatives are equal everywhere",
                "there is no intersection"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0925",
            question = "A differential equation contains:",
            options = listOf(
                "derivatives of dependent variables",
                "only constants",
                "only matrices",
                "only determinants"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0926",
            question = "The order of a differential equation is the:",
            options = listOf(
                "highest order derivative present",
                "number of variables",
                "degree of constant",
                "number of solutions"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0927",
            question = "dy/dx=0 has general solution:",
            options = listOf(
                "y=C",
                "y=x",
                "y=eˣ",
                "y=x²"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0928",
            question = "The solution of dy/dx=y is:",
            options = listOf(
                "y=Ceˣ",
                "y=Cx",
                "y=C+eˣ",
                "y=ln x+C"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_9",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0929",
            question = "A vector has:",
            options = listOf(
                "magnitude and direction",
                "only magnitude",
                "only direction",
                "neither"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0930",
            question = "The dot product of perpendicular vectors is:",
            options = listOf(
                "0",
                "1",
                "-1",
                "|a||b|"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0931",
            question = "The magnitude of vector ai+bj+ck is:",
            options = listOf(
                "√(a²+b²+c²)",
                "a+b+c",
                "abc",
                "a²+b²+c²"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0932",
            question = "If a·b=0 for non-zero vectors, they are:",
            options = listOf(
                "perpendicular",
                "parallel",
                "equal",
                "opposite only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_10",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0933",
            question = "Distance between two points in 3D is:",
            options = listOf(
                "√((x₂-x₁)²+(y₂-y₁)²+(z₂-z₁)²)",
                "sum of coordinates",
                "product of coordinates",
                "determinant only"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0934",
            question = "Direction cosines l,m,n satisfy:",
            options = listOf(
                "l²+m²+n²=1",
                "l+m+n=1",
                "lmn=1",
                "l²+m²+n²=0"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0935",
            question = "The equation x/2=y/3=z/4 represents a:",
            options = listOf(
                "line through origin",
                "plane",
                "sphere",
                "circle"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0936",
            question = "Two lines are skew when they are:",
            options = listOf(
                "non-coplanar and non-intersecting",
                "parallel only",
                "intersecting",
                "coincident"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_11",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0937",
            question = "In linear programming, the feasible region is determined by:",
            options = listOf(
                "constraints",
                "only objective function",
                "only variables",
                "determinant"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0938",
            question = "The objective function is:",
            options = listOf(
                "a function to be maximized or minimized",
                "a constraint only",
                "a matrix",
                "a probability"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0939",
            question = "For a bounded feasible region, optimum generally occurs at:",
            options = listOf(
                "a corner point",
                "any random point",
                "the origin always",
                "the midpoint always"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0940",
            question = "A maximization problem may become unbounded when:",
            options = listOf(
                "constraints do not bound the objective in a direction",
                "there are two variables",
                "there is one constraint",
                "the objective is linear"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_12",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0941",
            question = "The probability of an impossible event is:",
            options = listOf(
                "0",
                "1",
                "1/2",
                "-1"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_13",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0942",
            question = "The probability of a sure event is:",
            options = listOf(
                "1",
                "0",
                "1/2",
                "-1"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_13",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.EASY,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0943",
            question = "For independent events A and B, P(A∩B)=:",
            options = listOf(
                "P(A)P(B)",
                "P(A)+P(B)",
                "P(A)-P(B)",
                "P(A)/P(B)"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_13",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(
            id = "mathematics_class_12_new_0944",
            question = "Bayes theorem is used to find:",
            options = listOf(
                "posterior probability",
                "only mean",
                "only variance",
                "determinant"
            ),
            correctAnswer = 0,
            explanation = "Correct option from the supplied MCQ source.",
            subjectId = "mathematics",
            chapterId = "mathematics_class_12_13",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.HARD,
            tags = listOf("class12", "mp_board", "master_mcq")
        ),
        Question(

            id = "economics_class_12__012",
            question = "Fiscal policy mainly uses:",
            options = listOf(
                "Government taxation and expenditure",
                "Only bank deposits",
                "Only exports",
                "Only wages"
            ),
            correctAnswer = 0,
            explanation = "Fiscal policy uses government revenue and expenditure decisions.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__013",
            question = "Balance of Payments records:",
            options = listOf(
                "Economic transactions with the rest of the world",
                "Only domestic sales",
                "Only government budgets",
                "Only bank deposits"
            ),
            correctAnswer = 0,
            explanation = "BOP records international economic transactions.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__014",
            question = "Liberalisation means:",
            options = listOf(
                "Reducing unnecessary government controls",
                "Increasing all controls",
                "Banning private firms",
                "Ending international trade"
            ),
            correctAnswer = 0,
            explanation = "Liberalisation reduces restrictions on economic activity.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__015",
            question = "Human capital formation includes investment in:",
            options = listOf(
                "Education, health and skills",
                "Only land",
                "Only machines",
                "Only buildings"
            ),
            correctAnswer = 0,
            explanation = "Education, health and skills build human capital.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__016",
            question = "Rural development aims to improve:",
            options = listOf(
                "Economic and social conditions in rural areas",
                "Only city transport",
                "Only stock markets",
                "Only imports"
            ),
            correctAnswer = 0,
            explanation = "Rural development addresses livelihoods, infrastructure and social conditions.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__017",
            question = "Sustainable development means:",
            options = listOf(
                "Meeting present needs without harming future capacity",
                "Using all resources immediately",
                "Ignoring environmental costs",
                "Stopping all development"
            ),
            correctAnswer = 0,
            explanation = "Sustainable development balances present needs and future generations.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__018",
            question = "The basic economic problem arises because resources are:",
            options = listOf(
                "Scarce relative to wants",
                "Unlimited",
                "Always free",
                "Equal to wants"
            ),
            correctAnswer = 0,
            explanation = "Scarcity relative to unlimited wants creates the economic problem.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__019",
            question = "Marginal utility is:",
            options = listOf(
                "Change in total utility from one more unit",
                "Total income",
                "Change in price only",
                "Total cost"
            ),
            correctAnswer = 0,
            explanation = "Marginal utility is the additional utility from an additional unit.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__031",
            question = "Liberalisation means:",
            options = listOf(
                "Reducing unnecessary government controls",
                "Increasing all controls",
                "Banning private firms",
                "Ending international trade"
            ),
            correctAnswer = 0,
            explanation = "Liberalisation reduces restrictions on economic activity.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__032",
            question = "Human capital formation includes investment in:",
            options = listOf(
                "Education, health and skills",
                "Only land",
                "Only machines",
                "Only buildings"
            ),
            correctAnswer = 0,
            explanation = "Education, health and skills build human capital.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_2",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__033",
            question = "Rural development aims to improve:",
            options = listOf(
                "Economic and social conditions in rural areas",
                "Only city transport",
                "Only stock markets",
                "Only imports"
            ),
            correctAnswer = 0,
            explanation = "Rural development addresses livelihoods, infrastructure and social conditions.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_3",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__034",
            question = "Sustainable development means:",
            options = listOf(
                "Meeting present needs without harming future capacity",
                "Using all resources immediately",
                "Ignoring environmental costs",
                "Stopping all development"
            ),
            correctAnswer = 0,
            explanation = "Sustainable development balances present needs and future generations.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_4",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__035",
            question = "The basic economic problem arises because resources are:",
            options = listOf(
                "Scarce relative to wants",
                "Unlimited",
                "Always free",
                "Equal to wants"
            ),
            correctAnswer = 0,
            explanation = "Scarcity relative to unlimited wants creates the economic problem.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_5",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__036",
            question = "Marginal utility is:",
            options = listOf(
                "Change in total utility from one more unit",
                "Total income",
                "Change in price only",
                "Total cost"
            ),
            correctAnswer = 0,
            explanation = "Marginal utility is the additional utility from an additional unit.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_6",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__037",
            question = "The law of demand generally shows:",
            options = listOf(
                "Inverse relation between price and quantity demanded",
                "Direct relation always",
                "No relation",
                "Fixed demand"
            ),
            correctAnswer = 0,
            explanation = "Other things equal, quantity demanded generally falls when price rises.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_7",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__038",
            question = "Fixed cost in the short run is:",
            options = listOf(
                "Independent of output",
                "Always zero",
                "Equal to variable cost",
                "Dependent on every unit produced"
            ),
            correctAnswer = 0,
            explanation = "Fixed cost does not vary with output in the short run.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_8",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        ),
        Question(

            id = "economics_class_12__050",
            question = "Rural development aims to improve:",
            options = listOf(
                "Economic and social conditions in rural areas",
                "Only city transport",
                "Only stock markets",
                "Only imports"
            ),
            correctAnswer = 0,
            explanation = "Rural development addresses livelihoods, infrastructure and social conditions.",
            subjectId = "economics",
            chapterId = "economics_class_12_ied_1",
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12,
            difficulty = QuestionDifficulty.MEDIUM,
            tags = listOf("class12", "mp_board")
        )
    )
}
