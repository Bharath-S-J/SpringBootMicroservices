import { Component, inject, OnInit } from '@angular/core';
import { OidcSecurityService } from "angular-auth-oidc-client";
import { CommonModule } from '@angular/common'; // ✅ Import CommonModule

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule],  // ✅ Add CommonModule to imports
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit {

  private readonly oidcSecurityService = inject(OidcSecurityService);
  isAuthenticated = false;
  username = "";
  menuOpen = false;  // Track mobile menu state

  ngOnInit(): void {
    this.oidcSecurityService.isAuthenticated$.subscribe(
      ({ isAuthenticated }) => {
        this.isAuthenticated = isAuthenticated;
      }
    );
    this.oidcSecurityService.userData$.subscribe(
      ({ userData }) => {
        this.username = userData.preferred_username;
      }
    );
  }

  toggleMenu() {
    this.menuOpen = !this.menuOpen;  // Toggle menu visibility
  }

  login(): void {
    this.oidcSecurityService.authorize();
  }

  logout(): void {
    this.oidcSecurityService
      .logoff()
      .subscribe((result) => console.log(result));
  }
}
