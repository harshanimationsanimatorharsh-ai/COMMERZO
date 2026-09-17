package com.commerzo.app.data.repository

import com.commerzo.app.data.model.Board
import com.commerzo.app.data.model.ClassLevel
import com.commerzo.app.data.model.Question
import com.commerzo.app.data.model.QuestionDifficulty

class QuestionRepository {

    fun getQuestions(
        subjectId: String,
        chapterId: String,
        board: Board = Board.MP_BOARD,
        classLevel: ClassLevel = ClassLevel.CLASS_12
    ): List<Question> {

        return questionBank()
            .filter {
                it.subjectId == subjectId &&
                    it.chapterId == chapterId &&
                    it.board == board &&
                    it.classLevel == classLevel
            }
    }

    /*
     * Backward-compatible overload for older callers.
     */
    fun getQuestions(
        subjectId: String,
        chapterId: String
    ): List<Question> {
        return getQuestions(
            subjectId = subjectId,
            chapterId = chapterId,
            board = Board.MP_BOARD,
            classLevel = ClassLevel.CLASS_12
        )
    }

    private fun questionBank(): List<Question> {

        return listOf(

            // =========================================================
            // ACCOUNTANCY — CLASS 12 — MP BOARD
            // =========================================================

            // ---------------------------------------------------------
            // CHAPTER 1 — ACCOUNTING FOR PARTNERSHIP: BASIC CONCEPTS
            // ---------------------------------------------------------

            Question(
                id = "acc_001",
                question = "In a partnership firm, the ratio in which partners agree to share profits and losses is called:",
                options = listOf(
                    "Capital ratio",
                    "Profit-sharing ratio",
                    "Current ratio",
                    "Debt-equity ratio"
                ),
                correctAnswer = 1,
                explanation = "The profit-sharing ratio is the ratio in which partners agree to share profits and losses.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_1",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("partnership", "profit-sharing-ratio")
            ),

            Question(
                id = "acc_002",
                question = "If there is no partnership agreement, profits and losses are generally shared by partners in:",
                options = listOf(
                    "Their capital ratio",
                    "Their salary ratio",
                    "Equal ratio",
                    "Their drawings ratio"
                ),
                correctAnswer = 2,
                explanation = "In the absence of an agreement, partners generally share profits and losses equally.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_1",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("partnership", "partnership-act")
            ),

            Question(
                id = "acc_003",
                question = "Interest on partner's capital is allowed only when it is provided by:",
                options = listOf(
                    "The Partnership Deed",
                    "The Cash Book",
                    "The Balance Sheet",
                    "The Trial Balance"
                ),
                correctAnswer = 0,
                explanation = "Interest on partners' capital is allowed when the partnership agreement or deed provides for it.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_1",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("interest-on-capital", "partnership-deed")
            ),

            Question(
                id = "acc_004",
                question = "A partner's salary is treated as an appropriation of:",
                options = listOf(
                    "Gross profit",
                    "Net profit",
                    "Capital",
                    "Assets"
                ),
                correctAnswer = 1,
                explanation = "Partner's salary is an appropriation of profit and is recorded through the Profit and Loss Appropriation Account.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_1",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("partner-salary", "appropriation")
            ),

            Question(
                id = "acc_005",
                question = "The account prepared to show the distribution of profit among partners is:",
                options = listOf(
                    "Trading Account",
                    "Profit and Loss Account",
                    "Profit and Loss Appropriation Account",
                    "Revaluation Account"
                ),
                correctAnswer = 2,
                explanation = "The Profit and Loss Appropriation Account shows how the firm's profit is appropriated among partners.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_1",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("appropriation-account", "partnership")
            ),

            Question(
                id = "acc_006",
                question = "Drawings made by a partner reduce the partner's:",
                options = listOf(
                    "Capital or current account balance",
                    "Sales",
                    "Liabilities",
                    "Gross profit"
                ),
                correctAnswer = 0,
                explanation = "Drawings represent withdrawals by a partner and reduce the partner's capital or current account balance.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_1",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("drawings", "partnership")
            ),

            Question(
                id = "acc_007",
                question = "Interest on drawings is:",
                options = listOf(
                    "An expense of the firm",
                    "An income for the firm",
                    "A liability to outsiders",
                    "A fixed asset"
                ),
                correctAnswer = 1,
                explanation = "Interest on drawings is charged to the partner and becomes income for the partnership firm.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_1",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("interest-on-drawings")
            ),

            Question(
                id = "acc_008",
                question = "The account used to record adjustments relating to partners' appropriations is:",
                options = listOf(
                    "Profit and Loss Appropriation Account",
                    "Trading Account",
                    "Cash Account",
                    "Purchases Account"
                ),
                correctAnswer = 0,
                explanation = "Partner salary, commission, interest on capital and interest on drawings are dealt with through the Profit and Loss Appropriation Account.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_1",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("appropriation-account")
            ),

            // ---------------------------------------------------------
            // CHAPTER 2 — ADMISSION OF A PARTNER
            // ---------------------------------------------------------

            Question(
                id = "acc_009",
                question = "When a new partner is admitted, the consent of existing partners is:",
                options = listOf(
                    "Not required",
                    "Required",
                    "Required only from one partner",
                    "Required only from creditors"
                ),
                correctAnswer = 1,
                explanation = "A new partner can be admitted only with the consent of all existing partners.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_2",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("admission", "partnership")
            ),

            Question(
                id = "acc_010",
                question = "The share acquired by a new partner from existing partners is called:",
                options = listOf(
                    "New profit share",
                    "Sacrificing share",
                    "Gaining share",
                    "Capital share"
                ),
                correctAnswer = 0,
                explanation = "The new partner receives a share of future profits, called the new partner's profit share.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_2",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("admission", "new-partner")
            ),

            Question(
                id = "acc_011",
                question = "Sacrificing ratio is calculated as:",
                options = listOf(
                    "New ratio − Old ratio",
                    "Old ratio − New ratio",
                    "Capital ratio − New ratio",
                    "New ratio + Old ratio"
                ),
                correctAnswer = 1,
                explanation = "Sacrificing ratio = Old ratio − New ratio.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_2",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("sacrificing-ratio", "admission")
            ),

            Question(
                id = "acc_012",
                question = "Goodwill brought in cash by a new partner is generally credited to:",
                options = listOf(
                    "New partner only",
                    "Sacrificing partners",
                    "Gaining partners",
                    "All creditors"
                ),
                correctAnswer = 1,
                explanation = "Cash goodwill brought by the new partner is credited to the old partners in their sacrificing ratio.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_2",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("goodwill", "admission")
            ),

            Question(
                id = "acc_013",
                question = "At the time of admission, accumulated profits are generally distributed among:",
                options = listOf(
                    "All partners including the new partner",
                    "Old partners",
                    "Creditors",
                    "New partner only"
                ),
                correctAnswer = 1,
                explanation = "Accumulated profits earned before admission belong to the old partners and are distributed among them in their old ratio.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_2",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("admission", "accumulated-profits")
            ),

            // ---------------------------------------------------------
            // CHAPTER 3 — RETIREMENT / DEATH OF A PARTNER
            // ---------------------------------------------------------

            Question(
                id = "acc_014",
                question = "On retirement of a partner, the remaining partners acquire the retiring partner's share in:",
                options = listOf(
                    "Sacrificing ratio",
                    "Gaining ratio",
                    "Old ratio only",
                    "Capital ratio only"
                ),
                correctAnswer = 1,
                explanation = "The remaining partners gain the retiring partner's share in their gaining ratio.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_3",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("retirement", "gaining-ratio")
            ),

            Question(
                id = "acc_015",
                question = "Gaining ratio is calculated as:",
                options = listOf(
                    "Old ratio − New ratio",
                    "New ratio − Old ratio",
                    "Old ratio + New ratio",
                    "Capital ratio − Old ratio"
                ),
                correctAnswer = 1,
                explanation = "Gaining ratio = New ratio − Old ratio.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_3",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("gaining-ratio", "retirement")
            ),

            Question(
                id = "acc_016",
                question = "The retiring partner's share of goodwill is borne by:",
                options = listOf(
                    "Remaining partners in gaining ratio",
                    "Retiring partner",
                    "Creditors",
                    "All employees"
                ),
                correctAnswer = 0,
                explanation = "The remaining partners compensate the retiring partner for goodwill in their gaining ratio.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_3",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("goodwill", "retirement")
            ),

            Question(
                id = "acc_017",
                question = "The amount due to a retiring partner may be transferred to:",
                options = listOf(
                    "Retiring Partner's Loan Account",
                    "Sales Account",
                    "Purchases Account",
                    "Trading Account"
                ),
                correctAnswer = 0,
                explanation = "If the amount due is not paid immediately, it may be transferred to the retiring partner's loan account.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_3",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("retirement", "loan-account")
            ),

            Question(
                id = "acc_018",
                question = "On the death of a partner, the amount due to the deceased partner is payable to:",
                options = listOf(
                    "The deceased partner's legal representative",
                    "Any creditor",
                    "The new partner",
                    "The government"
                ),
                correctAnswer = 0,
                explanation = "The amount due to a deceased partner is payable to the legal representative of the deceased partner.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_3",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("death-of-partner", "legal-representative")
            ),

            // ---------------------------------------------------------
            // CHAPTER 4 — DISSOLUTION OF PARTNERSHIP FIRM
            // ---------------------------------------------------------

            Question(
                id = "acc_019",
                question = "Dissolution of a firm means:",
                options = listOf(
                    "Change in profit-sharing ratio",
                    "Closure of the business of the firm",
                    "Admission of a partner",
                    "Increase in capital"
                ),
                correctAnswer = 1,
                explanation = "Dissolution of a firm involves the closure of the firm's business and settlement of its accounts.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_4",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("dissolution", "firm")
            ),

            Question(
                id = "acc_020",
                question = "At dissolution, the account prepared to determine profit or loss on realization is:",
                options = listOf(
                    "Revaluation Account",
                    "Realisation Account",
                    "Trading Account",
                    "Capital Account"
                ),
                correctAnswer = 1,
                explanation = "Realisation Account is prepared to record realization of assets and settlement of liabilities and determine realization profit or loss.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_4",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("realisation-account", "dissolution")
            ),

            Question(
                id = "acc_021",
                question = "When an asset is sold for cash at dissolution, the cash received is recorded on the:",
                options = listOf(
                    "Debit side of Realisation Account",
                    "Credit side of Realisation Account",
                    "Debit side of Capital Account",
                    "Credit side of Cash Account only"
                ),
                correctAnswer = 1,
                explanation = "Cash received from realization of assets is credited to the Realisation Account.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_4",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("realisation", "dissolution")
            ),

            Question(
                id = "acc_022",
                question = "At dissolution, liabilities are generally transferred to:",
                options = listOf(
                    "Realisation Account",
                    "Sales Account",
                    "Purchases Account",
                    "Drawings Account"
                ),
                correctAnswer = 0,
                explanation = "External liabilities are transferred to the Realisation Account at dissolution.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_4",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("liabilities", "realisation")
            ),

            Question(
                id = "acc_023",
                question = "Realisation profit or loss is transferred to partners' capital accounts in their:",
                options = listOf(
                    "New ratio",
                    "Old profit-sharing ratio",
                    "Gaining ratio",
                    "Capital ratio only"
                ),
                correctAnswer = 1,
                explanation = "Realisation profit or loss is shared among partners in their profit-sharing ratio existing before dissolution.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_4",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("realisation-profit", "dissolution")
            ),

            // ---------------------------------------------------------
            // CHAPTER 5 — ACCOUNTING FOR SHARE CAPITAL
            // ---------------------------------------------------------

            Question(
                id = "acc_024",
                question = "The capital of a company divided into units of a fixed amount is called:",
                options = listOf(
                    "Share capital",
                    "Loan capital",
                    "Working capital",
                    "Reserve capital only"
                ),
                correctAnswer = 0,
                explanation = "The capital raised by a company through issue of shares is called share capital.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_5",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("share-capital", "company")
            ),

            Question(
                id = "acc_025",
                question = "The amount of share capital mentioned in the Memorandum of Association is called:",
                options = listOf(
                    "Issued capital",
                    "Authorised capital",
                    "Subscribed capital",
                    "Called-up capital"
                ),
                correctAnswer = 1,
                explanation = "Authorised capital is the maximum share capital that a company is authorised to issue.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_5",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("authorised-capital")
            ),

            Question(
                id = "acc_026",
                question = "The part of authorised capital offered to the public for subscription is called:",
                options = listOf(
                    "Issued capital",
                    "Reserve capital",
                    "Called-up capital",
                    "Paid-up capital"
                ),
                correctAnswer = 0,
                explanation = "Issued capital is the portion of authorised capital that is offered for subscription.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_5",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("issued-capital")
            ),

            Question(
                id = "acc_027",
                question = "Amount called by the company from shareholders is known as:",
                options = listOf(
                    "Called-up capital",
                    "Authorised capital",
                    "Reserve capital",
                    "Nominal capital"
                ),
                correctAnswer = 0,
                explanation = "Called-up capital is the amount that the company has called from shareholders on the shares issued.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_5",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("called-up-capital")
            ),

            Question(
                id = "acc_028",
                question = "When shares are issued above their face value, they are issued at:",
                options = listOf(
                    "Par",
                    "Premium",
                    "Discount",
                    "Book value"
                ),
                correctAnswer = 1,
                explanation = "Issue of shares above their face value is called issue at premium.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_5",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("share-premium", "issue-of-shares")
            ),

            // ---------------------------------------------------------
            // CHAPTER 6 — ISSUE AND REDEMPTION OF DEBENTURES
            // ---------------------------------------------------------

            Question(
                id = "acc_029",
                question = "A debenture represents:",
                options = listOf(
                    "Ownership capital",
                    "Borrowed capital",
                    "Reserve",
                    "Revenue"
                ),
                correctAnswer = 1,
                explanation = "Debentures represent borrowed funds of a company and create a debt obligation.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_6",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("debentures", "borrowed-capital")
            ),

            Question(
                id = "acc_030",
                question = "Interest on debentures is generally:",
                options = listOf(
                    "An appropriation of profit",
                    "A charge against profit",
                    "A distribution of capital",
                    "A reserve"
                ),
                correctAnswer = 1,
                explanation = "Interest on debentures is a fixed financial charge against the profits of the company.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_6",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("debenture-interest")
            ),

            Question(
                id = "acc_031",
                question = "Debentures issued at a value equal to their face value are issued at:",
                options = listOf(
                    "Premium",
                    "Par",
                    "Discount",
                    "Market value"
                ),
                correctAnswer = 1,
                explanation = "When issue price equals face value, debentures are issued at par.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_6",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("debenture-issue", "par")
            ),

            Question(
                id = "acc_032",
                question = "Redemption of debentures means:",
                options = listOf(
                    "Issue of new shares",
                    "Repayment of debenture liability",
                    "Creation of reserve",
                    "Payment of dividend"
                ),
                correctAnswer = 1,
                explanation = "Redemption means repayment of the amount due on debentures according to their terms.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_6",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("redemption", "debentures")
            ),

            // ---------------------------------------------------------
            // CHAPTER 7 — FINANCIAL STATEMENTS OF A COMPANY
            // ---------------------------------------------------------

            Question(
                id = "acc_033",
                question = "The Balance Sheet of a company shows:",
                options = listOf(
                    "Financial position",
                    "Only cash transactions",
                    "Only sales",
                    "Only purchases"
                ),
                correctAnswer = 0,
                explanation = "The Balance Sheet presents the financial position of a company at a particular date.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_7",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("balance-sheet", "financial-statements")
            ),

            Question(
                id = "acc_034",
                question = "Statement of Profit and Loss primarily shows:",
                options = listOf(
                    "Financial position only",
                    "Profit or loss for the period",
                    "Shareholders' names",
                    "Cash balance only"
                ),
                correctAnswer = 1,
                explanation = "The Statement of Profit and Loss shows the income, expenses and resulting profit or loss for an accounting period.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_7",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("profit-and-loss", "financial-statements")
            ),

            Question(
                id = "acc_035",
                question = "Trade receivables are generally shown under:",
                options = listOf(
                    "Non-current liabilities",
                    "Current assets",
                    "Shareholders' funds",
                    "Non-current assets"
                ),
                correctAnswer = 1,
                explanation = "Trade receivables are generally classified as current assets because they are expected to be realised in the normal operating cycle.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_7",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("trade-receivables", "balance-sheet")
            ),

            // ---------------------------------------------------------
            // CHAPTER 8 — ACCOUNTING RATIOS
            // ---------------------------------------------------------

            Question(
                id = "acc_036",
                question = "Current Ratio is calculated as:",
                options = listOf(
                    "Current Assets / Current Liabilities",
                    "Current Liabilities / Current Assets",
                    "Quick Assets / Current Liabilities",
                    "Total Assets / Total Liabilities"
                ),
                correctAnswer = 0,
                explanation = "Current Ratio = Current Assets ÷ Current Liabilities.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_8",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("current-ratio", "ratios")
            ),

            Question(
                id = "acc_037",
                question = "Quick Ratio is also known as:",
                options = listOf(
                    "Acid-test ratio",
                    "Debt ratio",
                    "Gross profit ratio",
                    "Operating ratio"
                ),
                correctAnswer = 0,
                explanation = "Quick Ratio is also called the Acid-test Ratio.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_8",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("quick-ratio", "acid-test")
            ),

            Question(
                id = "acc_038",
                question = "Debt-Equity Ratio compares:",
                options = listOf(
                    "Debt with shareholders' funds",
                    "Sales with purchases",
                    "Profit with sales",
                    "Current assets with current liabilities"
                ),
                correctAnswer = 0,
                explanation = "Debt-Equity Ratio measures the relationship between long-term debt and shareholders' funds.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_8",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("debt-equity-ratio", "ratios")
            ),

            Question(
                id = "acc_039",
                question = "Gross Profit Ratio is generally calculated as:",
                options = listOf(
                    "Gross Profit / Revenue from Operations × 100",
                    "Net Profit / Assets × 100",
                    "Current Assets / Current Liabilities",
                    "Debt / Equity"
                ),
                correctAnswer = 0,
                explanation = "Gross Profit Ratio = Gross Profit ÷ Revenue from Operations × 100.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_8",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("gross-profit-ratio", "ratios")
            ),

            Question(
                id = "acc_040",
                question = "Return on Investment is a:",
                options = listOf(
                    "Profitability ratio",
                    "Liquidity ratio",
                    "Solvency ratio only",
                    "Activity ratio only"
                ),
                correctAnswer = 0,
                explanation = "Return on Investment measures profitability in relation to the investment made.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_8",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("ROI", "profitability")
            ),

            // ---------------------------------------------------------
            // CHAPTER 9 — CASH FLOW STATEMENT
            // ---------------------------------------------------------

            Question(
                id = "acc_041",
                question = "Cash Flow Statement shows changes in:",
                options = listOf(
                    "Cash and cash equivalents",
                    "Only fixed assets",
                    "Only share capital",
                    "Only inventory"
                ),
                correctAnswer = 0,
                explanation = "Cash Flow Statement reports inflows and outflows of cash and cash equivalents during an accounting period.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_9",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("cash-flow", "cash-equivalents")
            ),

            Question(
                id = "acc_042",
                question = "Cash flows are classified into:",
                options = listOf(
                    "Operating, Investing and Financing activities",
                    "Trading, Profit and Loss and Balance Sheet",
                    "Capital, Revenue and Personal",
                    "Current, Fixed and Intangible"
                ),
                correctAnswer = 0,
                explanation = "Cash flows are classified into operating, investing and financing activities.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_9",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("cash-flow", "activities")
            ),

            Question(
                id = "acc_043",
                question = "Purchase of machinery for cash is a cash flow from:",
                options = listOf(
                    "Operating activity",
                    "Investing activity",
                    "Financing activity",
                    "Non-cash activity"
                ),
                correctAnswer = 1,
                explanation = "Purchase of fixed assets such as machinery is an investing cash flow.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_9",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("cash-flow", "investing-activity")
            ),

            Question(
                id = "acc_044",
                question = "Issue of shares for cash is classified as:",
                options = listOf(
                    "Operating cash flow",
                    "Investing cash flow",
                    "Financing cash flow",
                    "Non-operating expense"
                ),
                correctAnswer = 2,
                explanation = "Issue of shares changes the company's financing structure and is therefore a financing cash flow.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_9",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("cash-flow", "financing-activity")
            ),

            Question(
                id = "acc_045",
                question = "Cash received from customers is generally classified as:",
                options = listOf(
                    "Operating activity",
                    "Investing activity",
                    "Financing activity",
                    "Capital reserve"
                ),
                correctAnswer = 0,
                explanation = "Cash received from customers arises from the main revenue-generating activities of the business and is an operating cash flow.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_9",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("cash-flow", "operating-activity")
            ),

            // ---------------------------------------------------------
            // ADDITIONAL MIXED ACCOUNTANCY QUESTIONS
            // ---------------------------------------------------------

            Question(
                id = "acc_046",
                question = "Which ratio is mainly used to assess short-term liquidity?",
                options = listOf(
                    "Current Ratio",
                    "Debt-Equity Ratio",
                    "Gross Profit Ratio",
                    "Return on Investment"
                ),
                correctAnswer = 0,
                explanation = "Current Ratio is a liquidity ratio used to assess the firm's ability to meet short-term obligations.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_8",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("liquidity", "current-ratio")
            ),

            Question(
                id = "acc_047",
                question = "A partner admitted into an existing partnership becomes entitled to profits from:",
                options = listOf(
                    "The date of admission according to the agreed terms",
                    "The beginning of the previous year automatically",
                    "The date of formation of the firm",
                    "Any date chosen by creditors"
                ),
                correctAnswer = 0,
                explanation = "The new partner becomes entitled to profits according to the terms agreed at the time of admission.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_2",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("admission", "profit-share")
            ),

            Question(
                id = "acc_048",
                question = "At dissolution, payment of an outside liability is recorded on the:",
                options = listOf(
                    "Debit side of Realisation Account",
                    "Credit side of Realisation Account",
                    "Credit side of Sales Account",
                    "Debit side of Trading Account"
                ),
                correctAnswer = 0,
                explanation = "When an outside liability is paid, the payment is debited to the Realisation Account.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_4",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("dissolution", "realisation")
            ),

            Question(
                id = "acc_049",
                question = "If Current Assets are ₹2,00,000 and Current Liabilities are ₹1,00,000, the Current Ratio is:",
                options = listOf(
                    "0.5 : 1",
                    "1 : 1",
                    "2 : 1",
                    "3 : 1"
                ),
                correctAnswer = 2,
                explanation = "Current Ratio = Current Assets ÷ Current Liabilities = ₹2,00,000 ÷ ₹1,00,000 = 2 : 1.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_8",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.MEDIUM,
                tags = listOf("current-ratio", "numerical")
            ),

            Question(
                id = "acc_050",
                question = "Which of the following is normally a financing cash flow?",
                options = listOf(
                    "Cash paid to suppliers",
                    "Purchase of machinery",
                    "Issue of shares for cash",
                    "Cash received from customers"
                ),
                correctAnswer = 2,
                explanation = "Issue of shares for cash is a financing activity because it changes the company's share capital.",
                subjectId = "accountancy",
                chapterId = "accountancy_class_12_9",
                board = Board.MP_BOARD,
                classLevel = ClassLevel.CLASS_12,
                difficulty = QuestionDifficulty.EASY,
                tags = listOf("cash-flow", "financing-activity")
            )
        )
    }
}
