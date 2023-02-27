<template>
    <ul class="mainmenu">
        <li v-for="(item, index) in navItems"
            :class="[item.hasDropdown ? 'has-droupdown has-menu-child-item' : '', item.megamenu ? 'with-megamenu' : '']"
            :key="`nav-item-${index}`">
            <router-link :to="item.link" class="nav-link its_new">
                {{ item.title }}
            </router-link>
            <ul v-if="item.hasDropdown" class="submenu">
                <li v-for="(subMenuItem, subMenuIndex) in item.dropdownItems"
                    :key="`sub-menu-item-${subMenuIndex}`">
                    <router-link :to="subMenuItem.link" :class="subMenuItem.class">
                        {{ subMenuItem.title }}
                        <i v-if="subMenuItem.class !== 'live-expo'" :class="`feather-${subMenuItem.icon}`"/>
                    </router-link>
                </li>
            </ul>
            <div v-if="item.megamenu" class="rn-megamenu">
                <div class="wrapper">
                    <div class="row row--0">
                        <div v-for="(megamenuItem, megamenuIndex) in item.megaMenuItems"
                             :key="`mega-menu-item-${megamenuIndex}`"
                             class="col-lg-3 single-mega-item">
                            <ul class="mega-menu-item">
                                <li v-for="(megamenuSubItem, megamenuSubIndex) in megamenuItem.items"
                                    :key="`mega-submenu-item-${megamenuSubIndex}`">
                                    <router-link :to="megamenuSubItem.link">
                                        {{ megamenuSubItem.title }} <i :class="`feather-${megamenuSubItem.icon}`"/>
                                    </router-link>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </li>
    </ul>
</template>

<script>
export default {
    name: 'Nav',
    data() {
        return {
            navItems: [
                {
                    link: '#',
                    title: 'Home',
                    hasDropdown: true,
                    megamenu: false,
                    dropdownItems: [
                        {link: '/', title: 'Home Page-01', icon: 'home'},
                        {link: '/index-02', title: 'Home Page-02', icon: 'home'},
                        {link: '/index-03', title: 'Home Page-03', icon: 'home'},
                        {link: '/index-04', title: 'Home Page-04', icon: 'home'},
                        {link: '/index-05', title: 'Home Page-05', icon: 'home'},
                        {link: '/index-06', title: 'Home Page-06', icon: 'home'},
                        {link: '/index-07', title: 'Home Page-07', icon: 'home'},
                        {link: '/index-08', title: 'Home Page-08', icon: 'home'},
                        {link: '/index-09', title: 'Home Page-09', icon: 'home'},
                        {link: '/index-10', title: 'Home Page-10', icon: 'home'},
                        {link: '/index-11', title: 'Home Page-11', icon: 'home'},
                        {link: '/index-12', title: 'Home Page-12', icon: 'home'},
                    ]
                },
                {
                    link: '/about',
                    title: 'About',
                    hasDropdown: false,
                    megamenu: false,
                },
                {
                    link: '#',
                    title: 'Explore',
                    hasDropdown: true,
                    megamenu: false,
                    dropdownItems: [
                        {link: '/explore-01', title: 'Explore Filter', icon: 'fast-forward'},
                        {link: '/explore-02', title: 'Explore Isotop', icon: 'fast-forward'},
                        {link: '/explore-03', title: 'Explore Carousel', icon: 'fast-forward'},
                        {link: '/explore-04', title: 'Explore Simple', icon: 'fast-forward'},
                        {link: '/explore-05', title: 'Explore Place Bid', icon: 'fast-forward'},
                        {link: '/explore-06', title: 'Place Bid With Filter', icon: 'fast-forward'},
                        {link: '/explore-07', title: 'Place Bid With Isotop', icon: 'fast-forward'},
                        {link: '/explore-08', title: 'Place Bid With Carousel', icon: 'fast-forward'},
                        {link: '/explore-09', title: 'Explore Style List', icon: 'fast-forward'},
                        {link: '/explore-10', title: 'Explore List Col-Two', icon: 'fast-forward'},
                        {link: '/explore-14', title: 'Explore Left Filter', icon: 'fast-forward'},
                        {link: '/explore-11', title: 'Live Explore', icon: 'fast-forward', class: 'live-expo'},
                        {link: '/explore-12', title: 'Live Explore Carousel', icon: 'fast-forward', class: 'live-expo'},
                        {link: '/explore-13', title: 'Live With Place Bid', icon: 'fast-forward', class: 'live-expo'},
                    ]
                },
                {
                    link: '#',
                    title: 'Pages',
                    hasDropdown: false,
                    megamenu: true,
                    megaMenuItems: [
                        {
                            items: [
                                {link: '/create', title: 'Create NFT', icon: 'file-plus'},
                                {link: '/upload-variants', title: 'Upload Type', icon: 'layers'},
                                {link: '/activity', title: 'Activity', icon: 'activity'},
                                {link: '/creator', title: 'Creators', icon: 'users'},
                                {link: '/collection', title: 'Our Collection', icon: 'package'},
                                {link: '/upcoming-projects', title: 'Upcoming Projects', icon: 'loader'}
                            ]
                        },
                        {
                            items: [
                                {link: '/login', title: 'Log In', icon: 'log-in'},
                                {link: '/sign-up', title: 'Registration', icon: 'user-plus'},
                                {link: '/forget', title: 'Forget Password', icon: 'lock'},
                                {link: '/author/1', title: 'Author/Profile(User)', icon: 'user'},
                                {link: '/connect', title: 'Connect to Wallet', icon: 'pocket'},
                                {link: '/privacy-policy', title: 'Privacy Policy', icon: 'file-text'}
                            ]
                        },
                        {
                            items: [
                                {link: '/product', title: 'Product', icon: 'folder'},
                                {link: '/product/1', title: 'Product Details', icon: 'layout'},
                                {link: '/ranking', title: 'NFT Ranking', icon: 'trending-up'},
                                {link: '/edit-profile', title: 'Edit Profile', icon: 'user'},
                                {link: '/blog-details/1', title: 'Blog Details', icon: 'edit'},
                                {link: '/404', title: '404', icon: 'alert-triangle'}
                            ]
                        },
                        {
                            items: [
                                {link: '/about', title: 'About Us', icon: 'award'},
                                {link: '/contact', title: 'Contact', icon: 'headphones'},
                                {link: '/support', title: 'Support/FAQ', icon: 'help-circle'},
                                {link: '/terms-condition', title: 'Terms & Condition', icon: 'list'},
                                {link: '/coming-soon', title: 'Coming Soon', icon: 'clock'},
                                {link: '/maintenance', title: 'Maintenance', icon: 'cpu'}
                            ]
                        }
                    ]
                },
                {
                    link: '#',
                    title: 'Blog',
                    hasDropdown: true,
                    megamenu: false,
                    dropdownItems: [
                        {link: '/blog-single-column', title: 'Blog Single Column', icon: 'fast-forward'},
                        {link: '/blog-col-two', title: 'Blog Two Column', icon: 'fast-forward'},
                        {link: '/blog-col-three', title: 'Blog Three Column', icon: 'fast-forward'},
                        {link: '/blog', title: 'Blog Four Column', icon: 'fast-forward'},
                        {link: '/blog-details/1', title: 'Blog Details', icon: 'fast-forward'}
                    ]
                },
                {
                    link: '/contact',
                    title: 'Contact',
                    hasDropdown: false,
                    megamenu: false,
                }
            ]
        }
    }
}
</script>