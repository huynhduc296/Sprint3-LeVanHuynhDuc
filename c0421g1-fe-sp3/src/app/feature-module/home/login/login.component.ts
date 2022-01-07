import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {MatDialog} from '@angular/material/dialog';
import {DataService} from '../../../entity/data';
import {Router} from '@angular/router';
import {LoginRequest} from '../../../entity/loginRequest';
import {AuthServiceService} from '../../../core-module/auth-service.service';
import {TokenStorageServiceService} from '../../../core-module/token-storage-service.service';
import {ToastrService} from 'ngx-toastr';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isLogin: boolean = false;
  loginRequest: LoginRequest;
  username: string;
  roles: string[] = [];
  imgCurrent: string = '';
  notification = '';
  contactForm = new FormGroup(
    {
      username: new FormControl(),
      password: new FormControl()
    }
  );

  constructor(private authService: AuthServiceService,
              private tokenStorageService: TokenStorageServiceService,
              private dialog: MatDialog,
              private data: DataService,
              private router: Router,
              private toast: ToastrService) {
  }

  ngOnInit(): void {
    this.checkToken()
  }

  login() {
    this.loginRequest = this.contactForm.value
    console.log(this.loginRequest)
    this.authService.login(this.loginRequest).subscribe(
      data => {
        if (this.contactForm.value.remember_me) {
          this.tokenStorageService.saveTokenLocal(data.accessToken);
          this.tokenStorageService.saveUserLocal(data);
        } else {
          this.tokenStorageService.saveTokenSession(data.accessToken);
          this.tokenStorageService.saveUserLocal(data);
        }
        this.authService.isLonggedIn = true;
        this.username = this.tokenStorageService.getUser().username;
        this.roles = this.tokenStorageService.getUser().roles;
        if (this.roles[0] == 'ADMIN') {
          this.imgCurrent = ''
        } else {
          this.imgCurrent = this.tokenStorageService.getUser().customer.image;
        }
        this.contactForm.reset();
        this.dialog.closeAll()
        this.router.navigateByUrl("/menu")
        this.toast.success("Xin Chào " + this.tokenStorageService.getUser().customer.name, "Thông báo")

      }, error => {
        console.log(error)
        this.notification = "Sai tên đăng nhập hoặc mật khẩu hoặc tài khoản chưa được kích hoạt", "Đăng nhập thất bại: "
      })
  }

  checkToken() {
    if (this.tokenStorageService.getUser()) {
      this.isLogin = true;
      this.username = this.tokenStorageService.getUser().customer.name
    }
  }

  signOut() {
    this.tokenStorageService.signOut()
    this.toast.warning("Đăng xuất thành công" , "Thông báo")
    this.dialog.closeAll()
  }

}
