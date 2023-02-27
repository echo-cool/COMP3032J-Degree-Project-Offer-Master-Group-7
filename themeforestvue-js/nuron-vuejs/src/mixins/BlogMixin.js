import AppFunctions from '@/helpers/AppFunctions'

export default {
    data() {
        return {
            posts: [
                {
                    id: 1,
                    img: require(`@/assets/images/blog/blog-01.jpg`),
                    publishedAt: '2021-05-02 11:10:00',
                    title: 'The services provide for design',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Development'],
                    tags: ['nftcollector', 'nftartist', 'ethereum'],
                    readingTime: '2 hour',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 2,
                    img: require(`@/assets/images/blog/blog-02.jpg`),
                    publishedAt: '2021-06-02 11:10:00',
                    title: 'More important feature for designer',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Design'],
                    tags: ['digitalart', 'cryptonews', 'metaverse'],
                    readingTime: '5 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 3,
                    img: require(`@/assets/images/blog/blog-03.jpg`),
                    publishedAt: '2021-05-03 11:10:00',
                    title: 'Inavalide purpose classes & motivation.',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Development'],
                    tags: ['defi', 'nonfungibletokens', 'cryptopunks'],
                    readingTime: '2 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 4,
                    img: require(`@/assets/images/blog/blog-04.jpg`),
                    publishedAt: '2021-05-04 11:10:00',
                    title: 'Canada is a great fact for NFT\'s',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Development'],
                    tags: ['nftcollector', 'ethereum', 'nftartist'],
                    readingTime: '1 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 5,
                    img: require(`@/assets/images/blog/blog-05.jpg`),
                    publishedAt: '2021-05-06 11:20:00',
                    title: 'Search your rare art from best artist.',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Development'],
                    tags: ['cryptotrading', 'eth', 'artoftheday'],
                    readingTime: '15 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 6,
                    img: require(`@/assets/images/blog/blog-06.jpg`),
                    publishedAt: '2021-05-07 11:10:00',
                    title: 'NFT\'s are too important for best artists',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Development'],
                    tags: ['nftcollectibles', 'art', 'artoftheday'],
                    readingTime: '7 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 7,
                    img: require(`@/assets/images/blog/blog-07.jpg`),
                    publishedAt: '2021-05-02 11:10:00',
                    title: 'Provide a rare theme in this market',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['CEO marketing'],
                    tags: ['nftcollectibles', 'art', 'artoftheday'],
                    readingTime: '11 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 8,
                    img: require(`@/assets/images/blog/blog-08.jpg`),
                    publishedAt: '2021-05-02 11:50:00',
                    title: 'Great image for great artists and NFT\'s',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['GIF IMAGE'],
                    tags: ['nftcollector', 'dogecoin', 'rarible'],
                    readingTime: '5 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 9,
                    img: require(`@/assets/images/blog/blog-09.jpg`),
                    publishedAt: '2021-05-02 11:10:00',
                    title: 'NFTs can be offer marketing opportunities',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Marketing'],
                    tags: ['dogecoin', 'nftcollectibles', 'metaverse'],
                    readingTime: '5 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 10,
                    img: require(`@/assets/images/blog/blog-10.jpg`),
                    publishedAt: '2021-05-02 11:33:00',
                    title: 'Unstoppable Hostings',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Development'],
                    tags: ['nftcollector', 'ethereum', 'nftartist'],
                    readingTime: '2 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 11,
                    img: require(`@/assets/images/blog/blog-01.jpg`),
                    publishedAt: '2021-05-02 08:13:00',
                    title: 'John Doe\'s charitable NFTs',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Development'],
                    tags: ['digitalart', 'cryptonews', 'metaverse'],
                    readingTime: '11 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 12,
                    img: require(`@/assets/images/blog/blog-02.jpg`),
                    publishedAt: '2021-05-07 05:25:00',
                    title: 'NFT for Better',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['GIF image'],
                    tags: ['defi', 'nonfungibletokens', 'cryptopunks'],
                    readingTime: '15 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 13,
                    img: require(`@/assets/images/blog/blog-03.jpg`),
                    publishedAt: '2021-05-02 08:50:00',
                    title: 'Share NFT tickets with your friends',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Condolance'],
                    tags: ['cryptotrading', 'nftcollectibles', 'artoftheday'],
                    readingTime: '2 hour',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 14,
                    img: require(`@/assets/images/blog/blog-04.jpg`),
                    publishedAt: '2021-05-02 10:45:00',
                    title: 'YT\'s NFT designs',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['CEO marketing'],
                    tags: ['cryptotrading', 'eth', 'artoftheday'],
                    readingTime: '1 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 15,
                    img: require(`@/assets/images/blog/blog-05.jpg`),
                    publishedAt: '2021-05-02 09:20:00',
                    title: 'NT\'s digital marketers',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Marketing'],
                    tags: ['nftcollector', 'nftcollectibles', 'startup'],
                    readingTime: '5 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 16,
                    img: require(`@/assets/images/blog/blog-06.jpg`),
                    publishedAt: '2021-05-03 12:50:00',
                    title: 'John Doe\'s Virtual Designs',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Digital Art'],
                    tags: ['nftcollectibles', 'art', 'artoftheday'],
                    readingTime: '11 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 17,
                    img: require(`@/assets/images/blog/blog-07.jpg`),
                    publishedAt: '2022-01-02 11:50:00',
                    title: 'Decentraland and Meta Verse',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Marketing'],
                    tags: ['nftcollector', 'dogecoin', 'rarible'],
                    readingTime: '1 hour',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 18,
                    img: require(`@/assets/images/blog/blog-08.jpg`),
                    publishedAt: '2021-05-04 11:50:00',
                    title: 'One of the first popular NFTs',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['GIF IMAGE'],
                    tags: ['digitalart', 'cryptonews', 'metaverse'],
                    readingTime: '5 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 19,
                    img: require(`@/assets/images/blog/blog-09.jpg`),
                    publishedAt: '2021-05-02 11:50:00',
                    title: 'Football Collections NY shots',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['CEO marketing'],
                    tags: ['defi', 'nonfungibletokens', 'cryptopunks'],
                    readingTime: '10 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 20,
                    img: require(`@/assets/images/blog/blog-10.jpg`),
                    publishedAt: '2021-05-05 11:50:00',
                    title: 'Jane Doe\'s first-ever NFT',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Condolance'],
                    tags: ['nftcollectibles', 'art', 'artoftheday'],
                    readingTime: '4 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 21,
                    img: require(`@/assets/images/blog/blog-01.jpg`),
                    publishedAt: '2022-02-02 11:50:00',
                    title: 'Ayan Dog GIF',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['NFT\'s'],
                    tags: ['cryptotrading', 'eth', 'artoftheday'],
                    readingTime: '15 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 22,
                    img: require(`@/assets/images/blog/blog-02.jpg`),
                    publishedAt: '2021-05-10 11:50:00',
                    title: 'Videos releases Car drive',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Design'],
                    tags: ['nftcollector', 'ethereum', 'nftartist'],
                    readingTime: '13 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 23,
                    img: require(`@/assets/images/blog/blog-03.jpg`),
                    publishedAt: '2021-08-02 11:67:00',
                    title: 'Beeple Everydays The First 10 Days',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Digital Art'],
                    tags: ['nftcollectibles', 'art', 'artoftheday'],
                    readingTime: '2 min',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                },
                {
                    id: 24,
                    img: require(`@/assets/images/blog/blog-04.jpg`),
                    publishedAt: '2021-05-02 11:50:00',
                    title: 'Great video for great artists and NFT\'s',
                    excerpt: 'We have always known the power of digital we\'ve.',
                    categories: ['Development'],
                    tags: ['digitalart', 'cryptonews', 'metaverse'],
                    readingTime: '2 hour',
                    body: `<p>Nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum.</p>
                           <h4>Nobis eleifend option conguenes.</h4>
                           <p>Mauris tempor, orci id pellentesque convallis, massa mi congue eros, sed posuere massa nunc quis dui. Integer ornare varius mi, in vehicula orci scelerisque sed. Fusce a massa nisi. Curabitur sit amet suscipit nisl. Sed eget nisl laoreet, suscipit enim nec, viverra eros. Nunc imperdiet risus leo, in rutrum erat dignissim id.</p>
                           <p>Ut rhoncus vestibulum facilisis. Duis et lorem vitae ligula cursus venenatis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc vitae nisi tortor. Morbi leo nulla, posuere vel lectus a, egestas posuere lacus. Fusce eleifend hendrerit bibendum. Morbi nec efficitur ex.</p>
                           <h4>Mauris tempor, orci id pellentesque.</h4>
                           <p>Nulla non ligula vel nisi blandit egestas vel eget leo. Praesent fringilla dapibus dignissim. Pellentesque quis quam enim. Vestibulum ultrices, leo id suscipit efficitur, odio lorem rhoncus dolor, a facilisis neque mi ut ex. Quisque tempor urna a nisi pretium, a pretium massa tristique. Nullam in aliquam diam. Maecenas at nibh gravida, ornare eros non, commodo ligula. Sed efficitur sollicitudin auctor. Quisque nec imperdiet purus, in ornare odio. Quisque odio felis, vestibulum et.</p>`,
                }
            ],
            categories: '',
            tags: '',
            AppFunctions
        }
    },
    methods: {
        blogCategories() {
            let cats = this.posts.map(item => {
                    return item.categories;
                }),
                singleCatArray = AppFunctions.flatDeep(cats),
                categories = [];

            singleCatArray.forEach(cat => {
                const obj = {
                    title: cat.trim(),
                    slug: AppFunctions.slugify(cat),
                    count: 1
                }
                const objIndex = AppFunctions.containsObject(obj, categories);
                if (objIndex !== -1) {
                    const prevCount = categories[objIndex].count;
                    categories[objIndex] = {
                        title: cat.trim(),
                        slug: AppFunctions.slugify(cat),
                        count: prevCount + 1
                    }
                } else {
                    categories.push(obj);
                }
            });

            this.categories = categories;
        },
        blogTags() {
            let tags = this.posts.map(item => {
                    return item.tags;
                }),
                singleTagArray = AppFunctions.flatDeep(tags),
                tagsData = [];

            singleTagArray.forEach(tag => {
                const obj = {
                        title: tag.trim(),
                        slug: AppFunctions.slugify(tag)
                    },
                    objIndex = AppFunctions.containsObject(obj, tagsData);

                if (objIndex !== -1) {
                    tagsData[objIndex] = {
                        title: tag.trim(),
                        slug: AppFunctions.slugify(tag)
                    }
                } else {
                    tagsData.push(obj);
                }
            });

            this.tags = tagsData;
        }
    },
    created() {
        this.blogCategories();
        this.blogTags();
    }
}