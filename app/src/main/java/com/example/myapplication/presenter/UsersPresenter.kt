package com.example.myapplication.presenter

import com.example.myapplication.GitHubUser
import com.example.myapplication.GitHubUsersRepo
import com.example.myapplication.view.IUserItemView
import com.example.myapplication.UsersListView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(private val usersRepo: GitHubUsersRepo, val router: Router) : MvpPresenter<UsersListView>() {

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GitHubUser>()
        override var itemClickListener: ((IUserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: IUserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
        }
    }

    fun loadData() {
        val users =  usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}