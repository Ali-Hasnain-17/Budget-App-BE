package com.pinchpenny.pinchpenny.services

import com.google.gson.Gson
import com.pinchpenny.pinchpenny.dtos.TransactionCreateRequest
import com.pinchpenny.pinchpenny.dtos.TransactionResponse
import com.pinchpenny.pinchpenny.dtos.toEntity
import com.pinchpenny.pinchpenny.dtos.toModel
import com.pinchpenny.pinchpenny.modals.Account
import com.pinchpenny.pinchpenny.modals.Category
import com.pinchpenny.pinchpenny.modals.Transaction
import com.pinchpenny.pinchpenny.modals.User
import com.pinchpenny.pinchpenny.repository.AccountRepository
import com.pinchpenny.pinchpenny.repository.CategoryRepository
import com.pinchpenny.pinchpenny.repository.TransactionRepository
import com.pinchpenny.pinchpenny.repository.UserRepository
import com.pinchpenny.pinchpenny.services.base.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.json.GsonJsonParser
import org.springframework.http.converter.json.GsonBuilderUtils
import org.springframework.http.converter.json.GsonFactoryBean
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.awt.print.Pageable
import java.util.Objects
import java.util.UUID
import java.util.stream.Collectors
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType
@Service
class TransactionServiceImpl:TransactionService {

    @Autowired private lateinit var transactionRepository: TransactionRepository
    @Autowired private lateinit var userRepository: UserRepository
    @Autowired private lateinit var accountRepository: AccountRepository
    @Autowired private lateinit var categoryRepository: CategoryRepository
    private var gson = Gson()
    override fun getTransactionsAgainstAccount(accountId:UUID): Any {
        val transactionList:List<Transaction> =  transactionRepository.findByAccount_Id(accountId).get()
        println("transactionList = $transactionList")
        val user:User = getCurrentLoggedInUser()
        val account:Account = accountRepository.findById(accountId).get()
        val categories:Map<UUID, Map<UUID, String>>
        return 1
    }

    override fun getTransactionAgainstUser(userId: UUID): List<TransactionResponse> {
        TODO("Not yet implemented")
    }

    override fun createTransaction(transaction: TransactionCreateRequest): TransactionResponse {
        val user:User = userRepository.findById(transaction.user_id).get()
        val account:Account = accountRepository.findById(transaction.account_id).get()
        val categories:List<Category> = categoryRepository.findByIdIn(transaction.categories).get()
        val categoriesMap:Map<UUID?, Map<UUID?, String>>  = categories
                                                    .associateBy({it.id}, { mapOf(it.mainId to it.title) })
        return transaction
            .toEntity(user = user, account = account, categories = categories)
            .let { transactionRepository.save(it) }
            .toModel(user = user, category = categoriesMap , account = account)
    }

//    override fun getTransactionAgainstUser(userId: UUID): List<TransactionResponse> {
//        val transactionList:List<Transaction> =  transactionRepository.findByUserId(userId).get()
//        transactionList.map { it.toModel( ) }
//    }

    fun getCurrentLoggedInUser():User {
        val userDetails = SecurityContextHolder.getContext().authentication.principal as UserDetails
        return userRepository.findByEmail(userDetails.username).get();
    }
}