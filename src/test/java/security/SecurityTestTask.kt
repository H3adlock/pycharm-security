package security

import com.intellij.codeInspection.LocalInspectionToolSession
import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.application.ApplicationManager
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import com.jetbrains.python.PythonFileType
import com.jetbrains.python.inspections.PyInspection
import com.jetbrains.python.inspections.PyInspectionVisitor
import com.jetbrains.python.psi.*
import com.nhaarman.mockitokotlin2.*
import org.jetbrains.annotations.NotNull
import org.mockito.Mockito
import security.validators.DjangoDebugModeSettingsInspection

open class SecurityTestTask: BasePlatformTestCase() {
    inline fun <inspector: PyInspection>testCodeAssignmentStatement(code: String, times: Int = 1, check: Checks.CheckType, filename: String = "test.py", instance: inspector){
        ApplicationManager.getApplication().runReadAction {
            val mockHolder = mock<ProblemsHolder> {
                on { registerProblem(any<PsiElement>(), eq(check.getDescription()), anyVararg<LocalQuickFix>()) } doAnswer {}
            }
            val testFile = this.createLightFile(filename, PythonFileType.INSTANCE.language, code);
            val mockLocalSession = mock<LocalInspectionToolSession> {
                on { file } doReturn (testFile)
            }
            assertNotNull(testFile)
            val testVisitor = instance.buildVisitor(mockHolder, true, mockLocalSession) as PyInspectionVisitor

            val expr: @NotNull MutableCollection<PyAssignmentStatement> = PsiTreeUtil.findChildrenOfType(testFile, PyAssignmentStatement::class.java)
            assertNotNull(expr)
            expr.forEach { e ->
                testVisitor.visitPyAssignmentStatement(e)
            }
            Mockito.verify(mockHolder, Mockito.times(times)).registerProblem(any<PsiElement>(), eq(check.getDescription()), anyVararg<LocalQuickFix>())
            Mockito.verify(mockLocalSession, Mockito.times(1)).file
        }
    }

    inline fun <inspector: PyInspection>testCodeCallExpression(code: String, times: Int = 1, check: Checks.CheckType, filename: String = "test.py", instance: inspector){
        ApplicationManager.getApplication().runReadAction {
            val mockHolder = mock<ProblemsHolder> {
                on { registerProblem(any<PsiElement>(), eq(check.getDescription()), anyVararg<LocalQuickFix>()) } doAnswer {}
            }
            val testFile = this.createLightFile(filename, PythonFileType.INSTANCE.language, code);
            val mockLocalSession = mock<LocalInspectionToolSession> {
                on { file } doReturn (testFile)
            }
            assertNotNull(testFile)
            val testVisitor = instance.buildVisitor(mockHolder, true, mockLocalSession) as PyInspectionVisitor

            val expr: @NotNull MutableCollection<PyCallExpression> = PsiTreeUtil.findChildrenOfType(testFile, PyCallExpression::class.java)
            assertNotNull(expr)
            expr.forEach { e ->
                testVisitor.visitPyCallExpression(e)
            }
            Mockito.verify(mockHolder, Mockito.times(times)).registerProblem(any<PsiElement>(), eq(check.getDescription()), anyVararg<LocalQuickFix>())
            Mockito.verify(mockLocalSession, Mockito.times(1)).file
        }
    }

    inline fun <inspector: PyInspection>testBinaryExpression(code: String, times: Int = 1, check: Checks.CheckType, filename: String = "test.py", instance: inspector){
        ApplicationManager.getApplication().runReadAction {
            val mockHolder = mock<ProblemsHolder> {
                on { registerProblem(any<PsiElement>(), eq(check.getDescription()), anyVararg<LocalQuickFix>()) } doAnswer {}
            }
            val testFile = this.createLightFile(filename, PythonFileType.INSTANCE.language, code);
            val mockLocalSession = mock<LocalInspectionToolSession> {
                on { file } doReturn (testFile)
            }
            assertNotNull(testFile)
            val testVisitor = instance.buildVisitor(mockHolder, true, mockLocalSession) as PyInspectionVisitor

            val expr: @NotNull MutableCollection<PyBinaryExpression> = PsiTreeUtil.findChildrenOfType(testFile, PyBinaryExpression::class.java)
            assertNotNull(expr)
            expr.forEach { e ->
                testVisitor.visitPyBinaryExpression(e)
            }
            Mockito.verify(mockHolder, Mockito.times(times)).registerProblem(any<PsiElement>(), eq(check.getDescription()), anyVararg<LocalQuickFix>())
            Mockito.verify(mockLocalSession, Mockito.times(1)).file
        }
    }

    inline fun <inspector: PyInspection>testStringLiteralExpression(code: String, times: Int = 1, check: Checks.CheckType, filename: String = "test.py", instance: inspector){
        ApplicationManager.getApplication().runReadAction {
            val mockHolder = mock<ProblemsHolder> {
                on { registerProblem(any<PsiElement>(), eq(check.getDescription()), anyVararg<LocalQuickFix>()) } doAnswer {}
            }
            val testFile = this.createLightFile(filename, PythonFileType.INSTANCE.language, code);
            val mockLocalSession = mock<LocalInspectionToolSession> {
                on { file } doReturn (testFile)
            }
            assertNotNull(testFile)
            val testVisitor = instance.buildVisitor(mockHolder, true, mockLocalSession) as PyInspectionVisitor

            val expr: @NotNull MutableCollection<PyStringLiteralExpression> = PsiTreeUtil.findChildrenOfType(testFile, PyStringLiteralExpression::class.java)
            assertNotNull(expr)
            expr.forEach { e ->
                testVisitor.visitPyStringLiteralExpression(e)
            }
            Mockito.verify(mockHolder, Mockito.times(times)).registerProblem(any<PsiElement>(), eq(check.getDescription()), anyVararg<LocalQuickFix>())
            Mockito.verify(mockLocalSession, Mockito.times(1)).file
        }
    }

    inline fun <inspector: PyInspection>testFormattedStringElement(code: String, times: Int = 1, check: Checks.CheckType, filename: String = "test.py", instance: inspector){
        ApplicationManager.getApplication().runReadAction {
            val mockHolder = mock<ProblemsHolder> {
                on { registerProblem(any<PsiElement>(), eq(check.getDescription()), anyVararg<LocalQuickFix>()) } doAnswer {}
            }
            val testFile = this.createLightFile(filename, PythonFileType.INSTANCE.language, code);
            val mockLocalSession = mock<LocalInspectionToolSession> {
                on { file } doReturn (testFile)
            }
            assertNotNull(testFile)
            val testVisitor = instance.buildVisitor(mockHolder, true, mockLocalSession) as PyInspectionVisitor

            val expr: @NotNull MutableCollection<PyFormattedStringElement> = PsiTreeUtil.findChildrenOfType(testFile, PyFormattedStringElement::class.java)
            assertNotNull(expr)
            expr.forEach { e ->
                testVisitor.visitPyFormattedStringElement(e)
            }
            Mockito.verify(mockHolder, Mockito.times(times)).registerProblem(any<PsiElement>(), eq(check.getDescription()), anyVararg<LocalQuickFix>())
            Mockito.verify(mockLocalSession, Mockito.times(1)).file
        }
    }

    inline fun <inspector: PyInspection>testAssertStatement(code: String, times: Int = 1, check: Checks.CheckType, filename: String = "test.py", instance: inspector){
        ApplicationManager.getApplication().runReadAction {
            val mockHolder = mock<ProblemsHolder> {
                on { registerProblem(any<PsiElement>(), eq(check.getDescription()), any<ProblemHighlightType>()) } doAnswer {}
            }
            val testFile = this.createLightFile(filename, PythonFileType.INSTANCE.language, code);
            val mockLocalSession = mock<LocalInspectionToolSession> {
                on { file } doReturn (testFile)
            }
            assertNotNull(testFile)
            val testVisitor = instance.buildVisitor(mockHolder, true, mockLocalSession) as PyInspectionVisitor

            val expr: @NotNull MutableCollection<PyAssertStatement> = PsiTreeUtil.findChildrenOfType(testFile, PyAssertStatement::class.java)
            assertNotNull(expr)
            expr.forEach { e ->
                testVisitor.visitPyAssertStatement(e)
            }
            Mockito.verify(mockHolder, Mockito.times(times)).registerProblem(any<PsiElement>(), eq(check.getDescription()), any<ProblemHighlightType>())
            Mockito.verify(mockLocalSession, Mockito.times(1)).file
        }
    }

    inline fun <inspector: PyInspection>testTryExceptStatement(code: String, times: Int = 1, check: Checks.CheckType, filename: String = "test.py", instance: inspector){
        ApplicationManager.getApplication().runReadAction {
            val mockHolder = mock<ProblemsHolder> {
                on { registerProblem(any<PsiElement>(), eq(check.getDescription()), any<ProblemHighlightType>()) } doAnswer {}
            }
            val testFile = this.createLightFile(filename, PythonFileType.INSTANCE.language, code);
            val mockLocalSession = mock<LocalInspectionToolSession> {
                on { file } doReturn (testFile)
            }
            assertNotNull(testFile)
            val testVisitor = instance.buildVisitor(mockHolder, true, mockLocalSession) as PyInspectionVisitor

            val expr: @NotNull MutableCollection<PyTryExceptStatement> = PsiTreeUtil.findChildrenOfType(testFile, PyTryExceptStatement::class.java)
            assertNotNull(expr)
            expr.forEach { e ->
                testVisitor.visitPyTryExceptStatement(e)
            }
            Mockito.verify(mockHolder, Mockito.times(times)).registerProblem(any<PsiElement>(), eq(check.getDescription()), any<ProblemHighlightType>())
            Mockito.verify(mockLocalSession, Mockito.times(1)).file
        }
    }
}