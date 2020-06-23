const MENU = {
  homeMenu:{ name: 'Home', path: '/home', roles: ['ROLE_ALL'] },
  // { name: 'Order', path: '/order' },
  // { name: 'Product', path: '/product' },
  // { name: 'Collection', path: '/collection' },
  userMenu: { name: 'Users', path: '/user', roles: ['ROLE_ADMIN', 'ROLE_USER'] },
  bioMenu:{ name: 'Bios', path: '/bio' , roles: ['ROLE_USER']},
};

interface MenuModel {
  name: string;
  path: string;
  roles: string[];
}

const ROLES = ['ROLE_USER','ROLE_ADMIN'];
export const getMenus = (roles: string[]) => {
  let menus: MenuModel[] = [];
  
  roles.forEach(r => {
    if(r === ROLES[0] || r === ROLES[1]){
      menus.push(MENU.bioMenu);
    }
    if(r === ROLES[1]) {
      menus.push(MENU.userMenu);
    }
  });
  menus.unshift(MENU.homeMenu);
  return menus;
}