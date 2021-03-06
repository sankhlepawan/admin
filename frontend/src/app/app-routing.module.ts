import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';
import { Shell } from '@app/shell/shell.service';

const routes: Routes = [
  Shell.childRoutes([
    { path: 'order', loadChildren: () => import('./order/order.module').then((m) => m.OrderModule) },
    { path: 'product', loadChildren: () => import('./product/product.module').then((m) => m.ProductModule) },
    { path: 'user', loadChildren: () => import('./user/user.module').then((m) => m.UserModule) },
    {
      path: 'collection',
      loadChildren: () => import('./collection/collection.module').then((m) => m.CollectionModule),
    },
    {
      path: 'bio',
      loadChildren: () => import('./bio/bio.module').then((m) => m.BioModule),
    },
  ]),
  { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })],
  exports: [RouterModule],
  providers: [],
})
export class AppRoutingModule {}
